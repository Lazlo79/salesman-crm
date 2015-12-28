package br.com.kproj.salesman.register.infrastructure.helpers;

import br.com.kproj.salesman.infrastructure.entity.person.Company;
import br.com.kproj.salesman.infrastructure.entity.person.Person;
import br.com.kproj.salesman.infrastructure.repository.Pager;
import br.com.kproj.salesman.register.application.contract.ClientApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientHelper {

    @Autowired
    private ClientApplication application;

    public Boolean isCompany(Person person) {

        return (person instanceof Company) ? Boolean.TRUE : Boolean.FALSE;
    }

    public Iterable<Person> getAllClients() {
        return application.findAll(Pager.build().withPageSize(10000));
    }

}
