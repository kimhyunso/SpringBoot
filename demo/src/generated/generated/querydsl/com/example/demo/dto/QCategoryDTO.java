package com.example.demo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.dto.QCategoryDTO is a Querydsl Projection type for CategoryDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCategoryDTO extends ConstructorExpression<CategoryDTO> {

    private static final long serialVersionUID = 52405144L;

    public QCategoryDTO(com.querydsl.core.types.Expression<Long> cateId, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<Character> isShow, com.querydsl.core.types.Expression<Character> isDrop) {
        super(CategoryDTO.class, new Class<?>[]{long.class, String.class, char.class, char.class}, cateId, content, isShow, isDrop);
    }

}

