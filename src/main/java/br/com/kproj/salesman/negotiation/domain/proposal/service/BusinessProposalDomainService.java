package br.com.kproj.salesman.negotiation.domain.proposal.service;

import br.com.kproj.salesman.infrastructure.entity.proposal.BusinessProposal;

public interface BusinessProposalDomainService {


    public void checkBusinessRulesFor(BusinessProposal businessProposal);

}
