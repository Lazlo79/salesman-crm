package br.com.kproj.salesman.negotiation.view.helpers;


import br.com.kproj.salesman.infrastructure.entity.enums.ProposalTemperature;
import br.com.kproj.salesman.infrastructure.entity.person.Person;
import br.com.kproj.salesman.infrastructure.entity.proposal.BusinessProposal;
import br.com.kproj.salesman.negotiation.application.NegotiationApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BusinessProposalHelper {

    private Map<ProposalTemperature, String> temperature = new HashMap<>();

    {
        temperature.put(ProposalTemperature.COLD, "/view-resource/assets/build/images/icons/icon_3.png" );
        temperature.put(ProposalTemperature.MOURN, "/view-resource/assets/build/images/icons/icon_2.png" );
        temperature.put(ProposalTemperature.HOT, "/view-resource/assets/build/images/icons/icon_1.png");
        temperature.put(ProposalTemperature.CLOSED_WON, "/view-resource/assets/build/images/icons/icon_4.png");
    }

    @Autowired
    private NegotiationApplication application;



    public List<BusinessProposal> getProposalsBy(Person client) {
        return application.findByClient(client);
    }

    public String getTemperatureIcon(BusinessProposal proposal) {
        if (proposal.getTemperature() == null) {
            return temperature.get(ProposalTemperature.COLD);
        }

        return temperature.get(proposal.getTemperature());
    }
}