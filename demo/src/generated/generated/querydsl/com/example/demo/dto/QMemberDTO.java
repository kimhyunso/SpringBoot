package com.example.demo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.demo.dto.QMemberDTO is a Querydsl Projection type for MemberDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberDTO extends ConstructorExpression<MemberDTO> {

    private static final long serialVersionUID = 1613273660L;

    public QMemberDTO(com.querydsl.core.types.Expression<Long> memberId, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> password, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> phoneNum, com.querydsl.core.types.Expression<String> ip) {
        super(MemberDTO.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class}, memberId, email, password, name, phoneNum, ip);
    }

}

