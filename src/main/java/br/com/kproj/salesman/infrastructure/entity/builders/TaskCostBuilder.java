package br.com.kproj.salesman.infrastructure.entity.builders;


import br.com.kproj.salesman.infrastructure.entity.task.Task;
import br.com.kproj.salesman.infrastructure.entity.task.TaskCost;

import java.math.BigDecimal;

public class TaskCostBuilder extends AbstractBuilder<TaskCost>  {

	public TaskCostBuilder() {
		this.entity = new TaskCost();
	}

	public TaskCostBuilder(Long id) {
		this();
		this.entity.setId(id);
	}

    public TaskCostBuilder withCost(BigDecimal cost) {
        this.entity.setCost(cost);
        return this;
    }

    public TaskCostBuilder withisInternal(Boolean isInternal) {
        this.entity.setIsInternal(isInternal);
        return this;
    }

    public TaskCostBuilder withDescription(String description) {
        this.entity.setDescription(description);
        return this;
    }

    public TaskCostBuilder withTask(Task task) {
        this.entity.setTask(task);
        return this;
    }

	
	public static TaskCostBuilder createTaskCost(Long id) {
		return new TaskCostBuilder(id);
	}

	public static TaskCostBuilder createTaskCost() {
		return new TaskCostBuilder();
	}
}