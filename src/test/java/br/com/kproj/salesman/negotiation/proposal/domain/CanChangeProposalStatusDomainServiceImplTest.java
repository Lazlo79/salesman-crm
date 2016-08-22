package br.com.kproj.salesman.negotiation.proposal.domain;

import br.com.kproj.salesman.infrastructure.entity.UserEntity;
import br.com.kproj.salesman.infrastructure.entity.proposal.BusinessProposal;
import br.com.kproj.salesman.infrastructure.entity.proposal.requestapproval.RequestApproval;
import br.com.kproj.salesman.infrastructure.exceptions.ValidationException;
import br.com.kproj.salesman.infrastructure.repository.ApproverProfileRepository;
import br.com.kproj.salesman.negotiation.proposal.approval.application.RequestApprovalApplication;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CanChangeProposalStatusDomainServiceImplTest {

    @InjectMocks
    private CanChangeProposalStatusDomainServiceImpl service;

    @Mock
    private ApproverProfileRepository profileRepository;

    @Mock
    private RequestApprovalApplication requestapproval;


    @Test
    public void shouldNotHaveErrosWhenHasApproversAndStatusRequestApprovalIsApproved () {
        UserEntity userMock = Mockito.mock(UserEntity.class);
        RequestApproval requestApprovalMock = Mockito.mock(RequestApproval.class);
        BusinessProposal bpMock = Mockito.mock(BusinessProposal.class);


        given(profileRepository.hasApproversExcludeParam(userMock)).willReturn(Boolean.TRUE);
        given(requestApprovalMock.getStatus()).willReturn(RequestApproval.RequestApprovalStatus.APPROVED);
        given(requestapproval.findLastRequestApproval(bpMock)).willReturn(Optional.of(requestApprovalMock));

        Boolean result = service.isValidBusinessRulesFor(bpMock, userMock);

        MatcherAssert.assertThat(result, is(Boolean.TRUE));

    }

    @Test
    public void shouldNotHaveErrosWhenNotHasApprovers() {
        UserEntity userMock = Mockito.mock(UserEntity.class);
        BusinessProposal bpMock = Mockito.mock(BusinessProposal.class);
        RequestApproval requestApprovalMock = Mockito.mock(RequestApproval.class);

        given(profileRepository.hasApproversExcludeParam(userMock)).willReturn(Boolean.FALSE);
        given(requestApprovalMock.getStatus()).willReturn(RequestApproval.RequestApprovalStatus.APPROVED);
        given(requestapproval.findLastRequestApproval(bpMock)).willReturn(Optional.of(requestApprovalMock));

        Boolean result = service.isValidBusinessRulesFor(bpMock, userMock);

        MatcherAssert.assertThat(result, is(Boolean.TRUE));

    }

    @Test(expected = ValidationException.class)
    public void shouldHaveErrosWhenHasApproversAndStatusRequestApprovalIsWaiting () {
        UserEntity userMock = Mockito.mock(UserEntity.class);
        RequestApproval requestApprovalMock = Mockito.mock(RequestApproval.class);
        BusinessProposal bpMock = Mockito.mock(BusinessProposal.class);


        given(profileRepository.hasApproversExcludeParam(userMock)).willReturn(Boolean.TRUE);
        given(requestApprovalMock.getStatus()).willReturn(RequestApproval.RequestApprovalStatus.WAITING);
        given(requestapproval.findLastRequestApproval(bpMock)).willReturn(Optional.of(requestApprovalMock));

        service.isValidBusinessRulesFor(bpMock, userMock);

    }

    @Test(expected = ValidationException.class)
    public void shouldHaveErrosWhenHasApproversAndStatusRequestApprovalIsDisapproved () {
        UserEntity userMock = Mockito.mock(UserEntity.class);
        RequestApproval requestApprovalMock = Mockito.mock(RequestApproval.class);
        BusinessProposal bpMock = Mockito.mock(BusinessProposal.class);


        given(profileRepository.hasApproversExcludeParam(userMock)).willReturn(Boolean.TRUE);
        given(requestApprovalMock.getStatus()).willReturn(RequestApproval.RequestApprovalStatus.DISAPPROVED);
        given(requestapproval.findLastRequestApproval(bpMock)).willReturn(Optional.of(requestApprovalMock));

        service.isValidBusinessRulesFor(bpMock, userMock);

    }

    @Test(expected = ValidationException.class)
    public void shouldHaveErrosWhenHasApproversAndNotHaveRequestApproval () {
        UserEntity userMock = Mockito.mock(UserEntity.class);
        BusinessProposal bpMock = Mockito.mock(BusinessProposal.class);


        given(profileRepository.hasApproversExcludeParam(userMock)).willReturn(Boolean.TRUE);
        given(requestapproval.findLastRequestApproval(bpMock)).willReturn(Optional.empty());

        service.isValidBusinessRulesFor(bpMock, userMock);
    }
}