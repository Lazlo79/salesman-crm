package br.com.kproj.salesman.infrastructure.entity.assistants.calendar;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCalendarEntity is a Querydsl query type for CalendarEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCalendarEntity extends EntityPathBase<CalendarEntity> {

    private static final long serialVersionUID = -650954169L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCalendarEntity calendarEntity = new QCalendarEntity("calendarEntity");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final ListPath<CalendarActivity, QCalendarActivity> activities = this.<CalendarActivity, QCalendarActivity>createList("activities", CalendarActivity.class, QCalendarActivity.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final br.com.kproj.salesman.infrastructure.entity.QUserEntity user;

    public QCalendarEntity(String variable) {
        this(CalendarEntity.class, forVariable(variable), INITS);
    }

    public QCalendarEntity(Path<? extends CalendarEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCalendarEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCalendarEntity(PathMetadata<?> metadata, PathInits inits) {
        this(CalendarEntity.class, metadata, inits);
    }

    public QCalendarEntity(Class<? extends CalendarEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new br.com.kproj.salesman.infrastructure.entity.QUserEntity(forProperty("user"), inits.get("user")) : null;
    }

}

