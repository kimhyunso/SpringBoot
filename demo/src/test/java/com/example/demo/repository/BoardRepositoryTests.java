package com.example.demo.repository;

import com.example.demo.domain.Category;
import com.example.demo.domain.Member;
import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MemberDTO;
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

        Member member = Member.MemberBuilder()
                .member_id(1L)
                .ip("192.168.0.0")
                .password("1234")
                .name("user")
                .email("member1")
                .phoneNum("01012345678")
                .build();

        Category category = Category.CategoryBuilder()
                .cate_id(1L)
                .content("내용물")
                .is_drop("0")
                .is_show("1")
                .build();


        BoardDTO boardDTO = BoardDTO.builder()
                .board_id(1L)
                .board_type("2")
                .title("업데이트 제목")
                .modifyer("업데이트 사용자")
                .is_notice('1')
                .is_secret('0')
                .member(member)
                .category(category)
                .content_normal("본문내용 업데이트")
                .build();


        boardService.save(boardDTO);
    }


}
