package br.com.kproj.salesman.negotiation.domain.proposal.saleable.contract;


import br.com.kproj.salesman.infrastructure.entity.proposal.ProposalSaleableItem;

import java.math.BigDecimal;
import java.util.List;

public interface ProposalCalcTotalSaleableItems {

    BigDecimal getTotal(List<ProposalSaleableItem> items);
}