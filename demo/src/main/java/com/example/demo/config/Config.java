package com.example.demo.config;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.BoardService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final MemberRepository memberRepository;

    private final CategoryRepository categoryRepository;

    private final BoardRepository boardRepository;

    @Autowired
    public Config(MemberRepository memberRepository, CategoryRepository categoryRepository, BoardRepository boardRepository){
        this.memberRepository = memberRepository;
        this.categoryRepository = categoryRepository;
        this.boardRepository = boardRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


    @Bean
    public CategoryService categoryService(){
        return new CategoryService(categoryRepository);
    }


    @Bean
    public BoardService boardService(){
        return new BoardService(boardRepository);
    }

}
