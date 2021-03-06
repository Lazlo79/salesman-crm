package br.com.kproj.salesman.infrastructure.entity.notification;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTaskNotification is a Querydsl query type for TaskNotification
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTaskNotification extends EntityPathBase<TaskNotification> {

    private static final long serialVersionUID = -2099919324L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTaskNotification taskNotification = new QTaskNotification("taskNotification");

    public final QNotification _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    //inherited
    public final NumberPath<Long> id;

    // inherited
    public final br.com.kproj.salesman.infrastructure.entity.QUserEntity notified;

    public final br.com.kproj.salesman.infrastructure.entity.task.QTaskEntity taskEntity;

    public QTaskNotification(String variable) {
        this(TaskNotification.class, forVariable(variable), INITS);
    }

    public QTaskNotification(Path<? extends TaskNotification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTaskNotification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTaskNotification(PathMetadata metadata, PathInits inits) {
        this(TaskNotification.class, metadata, inits);
    }

    public QTaskNotification(Class<? extends TaskNotification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QNotification(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.notified = _super.notified;
        this.taskEntity = inits.isInitialized("taskEntity") ? new br.com.kproj.salesman.infrastructure.entity.task.QTaskEntity(forProperty("taskEntity"), inits.get("taskEntity")) : null;
    }

}

