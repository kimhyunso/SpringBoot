package com.example.demo.config;

import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.BoardService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private MemberRepository memberRepository;

    private CategoryRepository categoryRepository;

    private BoardRepository boardRepository;

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
