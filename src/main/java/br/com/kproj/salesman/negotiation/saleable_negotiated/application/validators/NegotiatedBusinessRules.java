package br.com.kproj.salesman.negotiation.saleable_negotiated.application.validators;

import br.com.kproj.salesman.infrastructure.validators.CheckRule;
import br.com.kproj.salesman.infrastructure.validators.IgnoreRules;
import br.com.kproj.salesman.infrastructure.validators.RuleKey;
import br.com.kproj.salesman.infrastructure.validators.RulesExecute;
import br.com.kproj.salesman.negotiation.saleable_negotiated.domain.model.negotiated.Negotiated;
import br.com.kproj.salesman.negotiation.saleable_negotiated.domain.model.negotiated.NegotiatedValidate;
import br.com.kproj.salesman.negotiation.saleable_negotiated.domain.model.saleable.Saleable;
import br.com.kproj.salesman.negotiation.saleable_negotiated.domain.model.saleable.SaleablePackage;
import br.com.kproj.salesman.negotiation.saleable_negotiated.domain.model.saleable.SaleableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static br.com.kproj.salesman.infrastructure.helpers.NumberHelper.isNotNegativeNumber;
import static br.com.kproj.salesman.negotiation.saleable_negotiated.application.validators.NegotiatedRulesDescription.*;

@Component
public class NegotiatedBusinessRules implements NegotiatedValidate {


    private SaleableRepository saleableRepository;

    @Autowired
    public NegotiatedBusinessRules(SaleableRepository saleableRepository) {
        this.saleableRepository = saleableRepository;
    }


    private Map<RuleKey, CheckRule<NegotiatedVO>> persistRules = new HashMap<>();
    {
        persistRules.put(rulePrice(), (negotiatedVO) -> isNotNegativeNumber(negotiatedVO.negotiated.getPrice()));
        persistRules.put(ruleQuantity(), (negotiatedVO) -> negotiatedVO.negotiated.getQuantity() > 0);
        persistRules.put(ruleOriginalPrice(), (negotiatedVO) -> negotiatedVO.negotiated.getOriginalPrice() != null);

        persistRules.put(ruleSaleable(), (negotiatedVO) -> !saleableRepository.findOne(negotiatedVO.saleable.getId()).isPresent());

        persistRules.put(rulePackage(), (negotiatedVO) -> {
            Optional<Saleable> saleableFound = saleableRepository.findOne(negotiatedVO.saleable.getId());

            return saleableFound.get() instanceof SaleablePackage
                    ? ((SaleablePackage) saleableFound.get()).getSaleables().isEmpty()
                    : Boolean.FALSE;
        });

    }

    @Override
    public void checkRules(Negotiated negotiated, Saleable saleable) {

        NegotiatedVO negotiatedVO = new NegotiatedVO(negotiated, saleable);
        RulesExecute.runRules(persistRules, negotiatedVO);
    }

    @Override
    public void checkRules(Negotiated negotiated, IgnoreRules ignoreRules) {

        NegotiatedVO negotiatedVO = new NegotiatedVO(negotiated, null);
        RulesExecute.runRules(persistRules, negotiatedVO, ignoreRules);
    }

    private class NegotiatedVO {
        private Negotiated negotiated;
        private Saleable saleable;

        public NegotiatedVO(Negotiated negotiated, Saleable saleable) {
            this.negotiated = negotiated;
            this.saleable = saleable;
        }
    }
}
