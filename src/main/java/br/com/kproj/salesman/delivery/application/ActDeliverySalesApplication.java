package br.com.kproj.salesman.delivery.application;

import br.com.kproj.salesman.infrastructure.entity.ActDeliverySales;
import br.com.kproj.salesman.infrastructure.entity.sale.SalesOrder;
import br.com.kproj.salesman.infrastructure.service.ModelService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ActDeliverySalesApplication extends ModelService<ActDeliverySales> {

    List<SalesOrder> findNewSalesOrder();


    List<SalesOrder> findSalesOrderInActDelivery();
}