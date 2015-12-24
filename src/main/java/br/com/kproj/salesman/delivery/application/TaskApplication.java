package br.com.kproj.salesman.delivery.application;


import br.com.kproj.salesman.infrastructure.entity.User;
import br.com.kproj.salesman.infrastructure.entity.sale.SalesOrder;
import br.com.kproj.salesman.infrastructure.entity.task.Task;
import br.com.kproj.salesman.infrastructure.service.ModelService;

import java.util.List;

public interface TaskApplication extends ModelService<Task> {

    Task register(Task task);

    List<Task> findBySaleOrder(SalesOrder salesOrder);

    Boolean isSomeonesSon(Task task);

    void changeStatus(Task task, User userChange);

}