package br.com.kproj.salesman.infrastructure.entity.assistants.calendar;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCalendarActivity is a Querydsl query type for CalendarActivity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCalendarActivity extends EntityPathBase<CalendarActivity> {

    private static final long serialVersionUID = 1944404083L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCalendarActivity calendarActivity = new QCalendarActivity("calendarActivity");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final QCalendarEntity calendarEntity;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath location = createString("location");

    public final QPeriodEntity periodEntity;

    public final StringPath title = createString("title");

    public final QActivityType type;

    public QCalendarActivity(String variable) {
        this(CalendarActivity.class, forVariable(variable), INITS);
    }

    public QCalendarActivity(Path<? extends CalendarActivity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCalendarActivity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCalendarActivity(PathMetadata<?> metadata, PathInits inits) {
        this(CalendarActivity.class, metadata, inits);
    }

    public QCalendarActivity(Class<? extends CalendarActivity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.calendarEntity = inits.isInitialized("calendarEntity") ? new QCalendarEntity(forProperty("calendarEntity"), inits.get("calendarEntity")) : null;
        this.periodEntity = inits.isInitialized("periodEntity") ? new QPeriodEntity(forProperty("periodEntity"), inits.get("periodEntity")) : null;
        this.type = inits.isInitialized("type") ? new QActivityType(forProperty("type")) : null;
    }

}

