package com.example.demo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.dto.QCommentDTO is a Querydsl Projection type for CommentDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCommentDTO extends ConstructorExpression<CommentDTO> {

    private static final long serialVersionUID = 712662153L;

    public QCommentDTO(com.querydsl.core.types.Expression<Long> commentId, com.querydsl.core.types.Expression<Integer> parentId, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<String> writer, com.querydsl.core.types.Expression<String> modifyer, com.querydsl.core.types.Expression<? extends com.example.demo.domain.Board> board, com.querydsl.core.types.Expression<? extends com.example.demo.domain.Member> member) {
        super(CommentDTO.class, new Class<?>[]{long.class, int.class, String.class, String.class, String.class, com.example.demo.domain.Board.class, com.example.demo.domain.Member.class}, commentId, parentId, content, writer, modifyer, board, member);
    }

}

