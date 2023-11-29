package com.example.demo.config;

import com.example.demo.domain.AttachFile;
import com.example.demo.domain.Board;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final MemberRepository memberRepository;

    private final CategoryRepository categoryRepository;

    private final BoardRepository boardRepository;

    private final LogRepository logRepository;

    private final AttachRepository attachRepository;

    @Autowired
    public Config(MemberRepository memberRepository, CategoryRepository categoryRepository,
                  BoardRepository boardRepository, LogRepository logRepository, AttachRepository attachRepository){
        this.memberRepository = memberRepository;
        this.categoryRepository = categoryRepository;
        this.boardRepository = boardRepository;
        this.logRepository = logRepository;
        this.attachRepository = attachRepository;
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

    @Bean
    public LogService logService(){return new LogService(logRepository);}

    @Bean
    public AttachFileService attachFile(){return new AttachFileService(attachRepository);}

}
