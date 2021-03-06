package br.com.kproj.salesman.infrastructure.entity.auditing;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTaskAudinting is a Querydsl query type for TaskAudinting
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTaskAudinting extends EntityPathBase<TaskAudinting> {

    private static final long serialVersionUID = -501434010L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTaskAudinting taskAudinting = new QTaskAudinting("taskAudinting");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final NumberPath<Long> entityId = createNumber("entityId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath info = createString("info");

    public final DateTimePath<java.util.Date> lastUpdate = createDateTime("lastUpdate", java.util.Date.class);

    public final br.com.kproj.salesman.infrastructure.entity.QUserEntity user;

    public QTaskAudinting(String variable) {
        this(TaskAudinting.class, forVariable(variable), INITS);
    }

    public QTaskAudinting(Path<? extends TaskAudinting> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTaskAudinting(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTaskAudinting(PathMetadata metadata, PathInits inits) {
        this(TaskAudinting.class, metadata, inits);
    }

    public QTaskAudinting(Class<? extends TaskAudinting> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new br.com.kproj.salesman.infrastructure.entity.QUserEntity(forProperty("user"), inits.get("user")) : null;
    }

}

