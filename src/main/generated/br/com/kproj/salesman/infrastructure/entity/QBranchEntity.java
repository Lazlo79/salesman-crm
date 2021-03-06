package br.com.kproj.salesman.infrastructure.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBranchEntity is a Querydsl query type for BranchEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBranchEntity extends EntityPathBase<BranchEntity> {

    private static final long serialVersionUID = -1499949100L;

    public static final QBranchEntity branchEntity = new QBranchEntity("branchEntity");

    public final QIdentifiable _super = new QIdentifiable(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QBranchEntity(String variable) {
        super(BranchEntity.class, forVariable(variable));
    }

    public QBranchEntity(Path<? extends BranchEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBranchEntity(PathMetadata metadata) {
        super(BranchEntity.class, metadata);
    }

}

