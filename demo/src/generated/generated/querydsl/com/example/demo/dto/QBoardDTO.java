package com.example.demo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.dto.QBoardDTO is a Querydsl Projection type for BoardDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBoardDTO extends ConstructorExpression<BoardDTO> {

    private static final long serialVersionUID = 2035124450L;

    public QBoardDTO(com.querydsl.core.types.Expression<Long> boardId, com.querydsl.core.types.Expression<Character> isNotice, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<String> contentHTML, com.querydsl.core.types.Expression<Character> isSecret, com.querydsl.core.types.Expression<String> writer, com.querydsl.core.types.Expression<String> modifyer, com.querydsl.core.types.Expression<? extends com.example.demo.domain.Category> category, com.querydsl.core.types.Expression<? extends com.example.demo.domain.Member> member, com.querydsl.core.types.Expression<? extends java.util.List<com.example.demo.domain.AttachFile>> attachFiles) {
        super(BoardDTO.class, new Class<?>[]{long.class, char.class, String.class, String.class, String.class, char.class, String.class, String.class, com.example.demo.domain.Category.class, com.example.demo.domain.Member.class, java.util.List.class}, boardId, isNotice, title, content, contentHTML, isSecret, writer, modifyer, category, member, attachFiles);
    }

}

