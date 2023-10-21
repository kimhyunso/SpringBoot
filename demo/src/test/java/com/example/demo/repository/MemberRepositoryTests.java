package com.example.demo.repository;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRole;
import com.example.demo.dto.MemberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

   /* private final PasswordEncoder encoder;
    private final MemberRepository repository;

    @Autowired
    public MemberRepositoryTests(PasswordEncoder encoder, MemberRepository repository){
        this.encoder = encoder;
        this.repository = repository;
    }


    @Test
    public void selectTest(){
        System.out.println(repository.findAll());
    }


    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1, 100).forEach(i->{
            MemberDTO memberDTO = MemberDTO.builder()
                    .memberIdx(Long.valueOf(i))
                    .email("user" + i + "@naver.com")
                    .name("사용자" + i)
                    .password(encoder.encode("1111"))
                    .ip("192.168.0.5")
                    .phoneNum("01012345678")
                    .regDate(new Date())
                    .build();

            Member member = Member.builder(memberDTO).build();
            member.addMemberRole(MemberRole.USER);

            if (i > 80)
                member.addMemberRole(MemberRole.MANAGER);

            if (i > 90)
                member.addMemberRole(MemberRole.ADMIN);

            repository.save(member);
        });
    }*/

}
