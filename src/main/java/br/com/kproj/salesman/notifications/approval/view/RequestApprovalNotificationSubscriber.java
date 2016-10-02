package br.com.kproj.salesman.notifications.approval.view;


import br.com.kproj.salesman.infrastructure.events.NewRequestApprovalMessage;
import br.com.kproj.salesman.infrastructure.service.Serializer;
import br.com.kproj.salesman.notifications.approval.application.ApprovalNotificationFacade;
import br.com.kproj.salesman.notifications.approval.domain.model.negotiation.Negotiation;
import br.com.kproj.salesman.notifications.approval.domain.model.notification.Receivers;
import br.com.kproj.salesman.notifications.approval.domain.model.notification.RequestNotification;
import br.com.kproj.salesman.notifications.approval.domain.model.user.Receiver;
import br.com.kproj.salesman.notifications.approval.view.dtos.RequestApprovalDTO;
import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.kproj.salesman.notifications.approval.domain.model.notification.RequestNotification.createRequest;

@Component
public class RequestApprovalNotificationSubscriber {

    private Serializer serializer;

    private ApprovalNotificationFacade service;

    @Autowired
    public RequestApprovalNotificationSubscriber(Serializer serializer, ApprovalNotificationFacade service) {
        this.serializer = serializer;
        this.service = service;
    }


    @Subscribe
    public void receiveRequestApproval(NewRequestApprovalMessage message) {
        RequestApprovalDTO approvalDTO = serializer.deserialize(message.getMessage(), RequestApprovalDTO.class);
        Long negotiationId = approvalDTO.getNegotiation().getId();
        Receivers receivers = new Receivers();


        approvalDTO.getApprovers().stream()
                .forEach(approver -> {
                    Long id = approver.getApprover().getId();
                    receivers.add(new Receiver(id));
                });

        RequestNotification requestNotification = createRequest(new Negotiation(negotiationId), receivers);
        service.register(requestNotification);
    }



}
