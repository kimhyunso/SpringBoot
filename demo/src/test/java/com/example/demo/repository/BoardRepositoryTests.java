package com.example.demo.repository;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.service.BoardService;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void getBoardListTest(){
        assertNotNull(boardService.getBoardList());
    }

    @Test
    public void saveTest(){
        IntStream.rangeClosed(1, 10).forEach(i->{

        });
    }

    @Test
    public void updateTest(){
        BoardDTO boardDTO = BoardDTO.builder()
                .board_id(1L)
                .board_type("2")
                .title("업데이트 제목")
                .modifyer("업데이트 사용자")
                .is_notice('1')
                .is_secret('0')
                .content_normal("본문내용 업데이트")
                .build();


        boardService.save(boardDTO);
    }


}
