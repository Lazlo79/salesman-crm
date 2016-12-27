package br.com.kproj.salesman.assistants.activities.view.support.resource;



import br.com.kproj.salesman.assistants.activities.domain.model.personal.rootactivity.RootActivity;
import br.com.uol.rest.apiconverter.resources.Item;
import br.com.uol.rest.infrastructure.annotations.ResourceItem;
import br.com.uol.rest.infrastructure.annotations.Selectable;
import br.com.uol.rest.infrastructure.annotations.SuperClass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Collection;

@JsonPropertyOrder({
        "id",
        "task",
        "links"
})
@ResourceItem(name="personal-root-activities", modelReference = RootActivity.class, parent = ActivityResource.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RootActivityResource extends Item {

    private Long id;

    @SuperClass
    private ActivityResource task;

    private Collection<SubActivityResource> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Selectable(expression = "is-a", expandByDefault = true)
    public ActivityResource getTask() {
        return task;
    }

    public void setTask(ActivityResource task) {
        this.task = task;
    }

    @Selectable(expression = "children", externalLink = true, noExpandAnyWay = true)
    public Collection<SubActivityResource> getChildren() {
        return children;
    }

    public void setChildren(Collection<SubActivityResource> children) {
        this.children = children;
    }

    @JsonIgnore
    public Long getTaskId() {
        return this.task == null ? null : this.task.getId();
    }
}
