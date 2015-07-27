package br.com.kproj.salesman.infrastructure.entity.proposal;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBusinessProposal is a Querydsl query type for BusinessProposal
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBusinessProposal extends EntityPathBase<BusinessProposal> {

    private static final long serialVersionUID = -1363083457L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBusinessProposal businessProposal = new QBusinessProposal("businessProposal");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final StringPath careOf = createString("careOf");

    public final DateTimePath<java.util.Date> deliveryForeCast = createDateTime("deliveryForeCast", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath introduction = createString("introduction");

    public final ListPath<ProposalPaymentItem, QProposalPaymentItem> paymentItems = this.<ProposalPaymentItem, QProposalPaymentItem>createList("paymentItems", ProposalPaymentItem.class, QProposalPaymentItem.class, PathInits.DIRECT2);

    public final br.com.kproj.salesman.infrastructure.entity.person.QPerson person;

    public final ListPath<ProposalProductItem, QProposalProductItem> productItems = this.<ProposalProductItem, QProposalProductItem>createList("productItems", ProposalProductItem.class, QProposalProductItem.class, PathInits.DIRECT2);

    public final br.com.kproj.salesman.infrastructure.entity.QUser vendor;

    public QBusinessProposal(String variable) {
        this(BusinessProposal.class, forVariable(variable), INITS);
    }

    public QBusinessProposal(Path<? extends BusinessProposal> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBusinessProposal(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBusinessProposal(PathMetadata<?> metadata, PathInits inits) {
        this(BusinessProposal.class, metadata, inits);
    }

    public QBusinessProposal(Class<? extends BusinessProposal> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.person = inits.isInitialized("person") ? new br.com.kproj.salesman.infrastructure.entity.person.QPerson(forProperty("person"), inits.get("person")) : null;
        this.vendor = inits.isInitialized("vendor") ? new br.com.kproj.salesman.infrastructure.entity.QUser(forProperty("vendor"), inits.get("vendor")) : null;
    }

}
