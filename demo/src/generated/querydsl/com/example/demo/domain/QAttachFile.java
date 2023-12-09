package com.example.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAttachFile is a Querydsl query type for AttachFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttachFile extends EntityPathBase<AttachFile> {

    private static final long serialVersionUID = 1073744049L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAttachFile attachFile = new QAttachFile("attachFile");

    public final QBoard board;

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> downCnt = createNumber("downCnt", Integer.class);

    public final NumberPath<Long> fileId = createNumber("fileId", Long.class);

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Integer> fileSize = createNumber("fileSize", Integer.class);

    public final QMember member;

    public final DateTimePath<java.time.LocalDateTime> modifyAt = createDateTime("modifyAt", java.time.LocalDateTime.class);

    public final StringPath orgName = createString("orgName");

    public QAttachFile(String variable) {
        this(AttachFile.class, forVariable(variable), INITS);
    }

    public QAttachFile(Path<? extends AttachFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAttachFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAttachFile(PathMetadata metadata, PathInits inits) {
        this(AttachFile.class, metadata, inits);
    }

    public QAttachFile(Class<? extends AttachFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board"), inits.get("board")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

