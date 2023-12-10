package com.example.demo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.dto.QLogDTO is a Querydsl Projection type for LogDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QLogDTO extends ConstructorExpression<LogDTO> {

    private static final long serialVersionUID = 279604740L;

    public QLogDTO(com.querydsl.core.types.Expression<Long> logId, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<String> userEmail, com.querydsl.core.types.Expression<String> ip) {
        super(LogDTO.class, new Class<?>[]{long.class, String.class, String.class, String.class}, logId, content, userEmail, ip);
    }

}

