package com.example.demo.config;

import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private MemberRepository memberRepository;

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
}
