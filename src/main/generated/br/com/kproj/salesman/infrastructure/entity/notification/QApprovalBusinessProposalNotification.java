package br.com.kproj.salesman.infrastructure.entity.notification;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QApprovalBusinessProposalNotification is a Querydsl query type for ApprovalBusinessProposalNotification
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QApprovalBusinessProposalNotification extends EntityPathBase<ApprovalBusinessProposalNotification> {

    private static final long serialVersionUID = -299578924L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApprovalBusinessProposalNotification approvalBusinessProposalNotification = new QApprovalBusinessProposalNotification("approvalBusinessProposalNotification");

    public final QNotification _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    //inherited
    public final NumberPath<Long> id;

    // inherited
    public final br.com.kproj.salesman.infrastructure.entity.QUserEntity notified;

    public final br.com.kproj.salesman.infrastructure.entity.proposal.QBusinessProposal proposal;

    public QApprovalBusinessProposalNotification(String variable) {
        this(ApprovalBusinessProposalNotification.class, forVariable(variable), INITS);
    }

    public QApprovalBusinessProposalNotification(Path<? extends ApprovalBusinessProposalNotification> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QApprovalBusinessProposalNotification(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QApprovalBusinessProposalNotification(PathMetadata<?> metadata, PathInits inits) {
        this(ApprovalBusinessProposalNotification.class, metadata, inits);
    }

    public QApprovalBusinessProposalNotification(Class<? extends ApprovalBusinessProposalNotification> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QNotification(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.notified = _super.notified;
        this.proposal = inits.isInitialized("proposal") ? new br.com.kproj.salesman.infrastructure.entity.proposal.QBusinessProposal(forProperty("proposal"), inits.get("proposal")) : null;
    }

}

