package com.example.demo.repository;

import com.example.demo.domain.Board;
import com.example.demo.domain.Category;
import com.example.demo.domain.Member;
import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MemberDTO;
import com.example.demo.service.BoardService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.MemberService;
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

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MemberService memberService;

    @Test
    public void getBoardListTest(){
        boardService.getBoardList().stream().forEach(boardDTO -> {
            System.out.println(boardDTO.getTitle());
        });
        // assertNotNull(boardService.getBoardList());
    }

    @Test
    public void saveTest(){
        // 1. CategoryService, boardService findOne ==> category_Id
        // 2. Category, Board = new () ==> 인스턴스 직접던지기

        Category category = categoryService.findOne(1L).get();

        Member member = memberService.findOne(1L).get();


        IntStream.rangeClosed(1, 10).forEach(i->{
            BoardDTO boardDTO = BoardDTO.builder()
                    .board_id(Long.valueOf(i))
                    .writer("작성자" + i)
                    .content_normal("내용" + i)
                    .content_html("<div>" + "내용" + i + "</div>")
                    .title("제목" + i)
                    .is_secret('0')
                    .is_notice('0')
                    .category(category)
                    .member(member)
                    .board_type("취미")
                    .build();

            boardService.save(boardDTO);
        });
    }

    @Test
    public void updateTest(){

        Category category = categoryService.findOne(1L).get();
        Member member = memberService.findOne(1L).get();

        BoardDTO boardDTO = BoardDTO.builder()
                .board_id(25L)
                .board_type("2")
                .title("업데이트 제목")
                .modifyer("업데이트 사용자")
                .content_html("<div>업데이트됨</div>")
                .writer("수정자")
                .is_notice('1')
                .is_secret('0')
                .member(member)
                .category(category)
                .content_normal("본문내용 업데이트")
                .build();


        boardService.update(boardDTO);
    }

    @Test
    public void deleteTest(){
        boardService.delete(1L);
    }


}
