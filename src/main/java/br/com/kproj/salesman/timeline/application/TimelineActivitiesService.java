package br.com.kproj.salesman.timeline.application;

import br.com.kproj.salesman.infrastructure.entity.AppFile;
import br.com.kproj.salesman.infrastructure.entity.Contact;
import br.com.kproj.salesman.infrastructure.entity.person.Person;
import br.com.kproj.salesman.infrastructure.entity.proposal.BusinessProposal;
import br.com.kproj.salesman.infrastructure.entity.timeline.Timeline;
import br.com.kproj.salesman.infrastructure.entity.timeline.items.TimelineActivity;
import br.com.kproj.salesman.infrastructure.service.ModelService;

public interface TimelineActivitiesService extends ModelService<TimelineActivity> {

    Timeline register(Person person, TimelineActivity item);

    Timeline register(BusinessProposal proposal, TimelineActivity item);

    Timeline register(Contact contact, TimelineActivity item);

    byte[] getActivityFile(TimelineActivity timelineActivity, AppFile appfile);

}