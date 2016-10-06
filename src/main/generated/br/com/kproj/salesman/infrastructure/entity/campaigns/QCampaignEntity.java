package br.com.kproj.salesman.infrastructure.entity.campaigns;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCampaignEntity is a Querydsl query type for CampaignEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCampaignEntity extends EntityPathBase<CampaignEntity> {

    private static final long serialVersionUID = -27924947L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCampaignEntity campaignEntity = new QCampaignEntity("campaignEntity");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final br.com.kproj.salesman.infrastructure.entity.QUserEntity createdBy;

    public final StringPath description = createString("description");

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final EnumPath<CampaignEntity.CampaignStatus> status = createEnum("status", CampaignEntity.CampaignStatus.class);

    public final br.com.kproj.salesman.infrastructure.entity.timeline.QTimeline timeline;

    public QCampaignEntity(String variable) {
        this(CampaignEntity.class, forVariable(variable), INITS);
    }

    public QCampaignEntity(Path<? extends CampaignEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCampaignEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCampaignEntity(PathMetadata<?> metadata, PathInits inits) {
        this(CampaignEntity.class, metadata, inits);
    }

    public QCampaignEntity(Class<? extends CampaignEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new br.com.kproj.salesman.infrastructure.entity.QUserEntity(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.timeline = inits.isInitialized("timeline") ? new br.com.kproj.salesman.infrastructure.entity.timeline.QTimeline(forProperty("timeline"), inits.get("timeline")) : null;
    }

}
