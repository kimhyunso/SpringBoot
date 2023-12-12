package com.example.demo.repository.querydsl;

import com.example.demo.domain.*;
import com.example.demo.domain.QAttachFile;
import com.example.demo.domain.QBoard;
import com.example.demo.domain.QComment;
import com.example.demo.domain.QMember;
import com.example.demo.dto.BoardDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BoardRepositoryImpl implements BoardRepositoryCustom{

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public Page<Board> getSearchPages(Pageable pageable, String searchValue){

        QBoard board = new QBoard("board");

        QAttachFile attachFile = QAttachFile.attachFile;
        QComment comment = QComment.comment;


        List<Board> content = queryFactory
                .select(board).distinct()
                .from(board)
                .leftJoin(board.attachFiles, attachFile)
                .leftJoin(board.comments, comment)
                .where(board.title.contains(searchValue).or(board.content.contains(searchValue)).or(board.contentHTML.contains(searchValue)).or(board.writer.contains(searchValue)))
                .fetch();


        Long count = queryFactory
                .select(board.count())
                .from(board)
                .fetchOne();



        return new PageImpl<>(content, pageable, count);
    }



}
