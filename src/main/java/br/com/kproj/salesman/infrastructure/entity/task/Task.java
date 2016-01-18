package br.com.kproj.salesman.infrastructure.entity.task;

import br.com.kproj.salesman.infrastructure.entity.Identifiable;
import br.com.kproj.salesman.infrastructure.entity.OperationRegion;
import br.com.kproj.salesman.infrastructure.entity.User;
import br.com.kproj.salesman.infrastructure.entity.enums.TaskStatus;
import br.com.kproj.salesman.infrastructure.entity.notification.Notification;
import br.com.kproj.salesman.infrastructure.entity.sale.SalesOrder;
import br.com.kproj.salesman.infrastructure.entity.timeline.Timeline;
import com.google.common.collect.Lists;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tasks")
public class Task extends Identifiable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "task.title.is.null")
    private String title;
    private String description;

    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name="parent_id")
    private List<Task> tasksChilds;

    @Column(name = "parent_id", updatable =false, insertable = false)
    private Long parentId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
    private List<Checklist> checklist;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
    private List<TaskCost> taskCosts;

    @ManyToOne
    @JoinColumn(name="sales_order_id")
    private SalesOrder salesOrder;

    @ManyToMany
    @JoinTable(name="task_user",
            joinColumns={@JoinColumn(name="task_id")},
            inverseJoinColumns={@JoinColumn(name="user_id")})
    private List<User> signedBy;

    @OneToOne
    @JoinColumn(name = "timeline_id")
    private Timeline timeline;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="task_id")
    private List<Notification> notifications;

    @ManyToOne
    @JoinColumn(name="operation_region_id")
    @NotNull(message = "task.region.not.informed")
    private OperationRegion region;

    public void addChild(Task task) {
        if (this.tasksChilds == null) {
            this.tasksChilds = Lists.newArrayList();
        }
        this.tasksChilds.add(task);
    }

    public void addCheckList(Checklist checklist) {
        if (this.checklist == null) {
            this.checklist = Lists.newArrayList();
        }
        this.checklist.add(checklist);
    }

    public void addTaskCost(TaskCost taskCost) {
        if (this.taskCosts == null) {
            this.taskCosts = Lists.newArrayList();
        }
        this.taskCosts.add(taskCost);
    }

    public void addSignedBy(User user) {
        if (this.signedBy == null) {
            this.signedBy = Lists.newArrayList();
        }
        this.signedBy.add(user);
    }

    public void addNotification(Notification notification) {
        if (this.notifications == null) {
            this.notifications = Lists.newArrayList();
        }
        this.notifications.add(notification);
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasksChilds() {
        return tasksChilds;
    }

    public void setTasksChilds(List<Task> tasksChilds) {
        this.tasksChilds = tasksChilds;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public List<Checklist> getChecklist() {
        return checklist;
    }

    public void setChecklist(List<Checklist> checklist) {
        this.checklist = checklist;
    }

    public List<TaskCost> getTaskCosts() {
        return taskCosts;
    }

    public void setTaskCosts(List<TaskCost> taskCosts) {
        this.taskCosts = taskCosts;
    }

    public List<User> getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(List<User> signedBy) {
        this.signedBy = signedBy;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public OperationRegion getRegion() {
        return region;
    }

    public void setRegion(OperationRegion region) {
        this.region = region;
    }
}
