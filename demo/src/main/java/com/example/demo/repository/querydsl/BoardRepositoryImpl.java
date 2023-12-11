package com.example.demo.repository.querydsl;

import com.example.demo.dto.BoardDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BoardRepositoryImpl implements BoardRepositoryCustom{

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public Page<BoardDTO> getSearchPages(Pageable pageable, String searchValue){



        return null;
    }



}
