package com.example.demo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.dto.QAttachFileDTO is a Querydsl Projection type for AttachFileDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QAttachFileDTO extends ConstructorExpression<AttachFileDTO> {

    private static final long serialVersionUID = 1156197013L;

    public QAttachFileDTO(com.querydsl.core.types.Expression<Long> fileId, com.querydsl.core.types.Expression<String> fileName, com.querydsl.core.types.Expression<Integer> fileSize, com.querydsl.core.types.Expression<String> orgName, com.querydsl.core.types.Expression<Integer> downCnt, com.querydsl.core.types.Expression<? extends com.example.demo.domain.Board> board, com.querydsl.core.types.Expression<? extends com.example.demo.domain.Member> member) {
        super(AttachFileDTO.class, new Class<?>[]{long.class, String.class, int.class, String.class, int.class, com.example.demo.domain.Board.class, com.example.demo.domain.Member.class}, fileId, fileName, fileSize, orgName, downCnt, board, member);
    }

}

