package br.com.kproj.salesman.products_catalog.application.impl;


import br.com.kproj.salesman.infrastructure.repository.BaseRepository;
import br.com.kproj.salesman.infrastructure.service.BaseModelServiceImpl;
import br.com.kproj.salesman.products_catalog.application.ServiceSaleableFacade;
import br.com.kproj.salesman.products_catalog.domain.model.saleables.services.Service;
import br.com.kproj.salesman.products_catalog.domain.model.saleables.services.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceSaleableServiceImpl extends BaseModelServiceImpl<Service> implements ServiceSaleableFacade {

    @Autowired
    private ServiceRepository repository;

    @Override
    public BaseRepository<Service, Long> getRepository() {
        return repository;
    }
}
