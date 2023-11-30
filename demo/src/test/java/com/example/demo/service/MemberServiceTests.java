
package com.example.demo.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@SpringBootTest
public class MemberServiceTests {
    
//    private final PasswordEncoder encoder;
////    private final MemberRepository repository;

//    @Autowired
//    public MemberRepositoryTests(PasswordEncoder encoder, MemberRepository repository){
//        this.encoder = encoder;
//        this.repository = repository;
//    }
//
//
//    @Test
//    public void selectTest(){
//        System.out.println(repository.findAll());
//    }
//
//
//    @Test
//    public void insertDummies(){
//        IntStream.rangeClosed(1, 100).forEach(i->{
//            MemberDTO memberDTO = MemberDTO.builder()
//                    .memberIdx(Long.valueOf(i))
//                    .email("user" + i + "@naver.com")
//                    .name("사용자" + i)
//                    .password(encoder.encode("1111"))
//                    .ip("192.168.0.5")
//                    .phoneNum("01012345678")
//                    .regDate(new Date())
//                    .build();
//
//            Member member = Member.builder(memberDTO).build();
//            member.addMemberRole(MemberRole.USER);
//
//            if (i > 80)
//                member.addMemberRole(MemberRole.MANAGER);
//
//            if (i > 90)
//                member.addMemberRole(MemberRole.ADMIN);
//
//            repository.save(member);
//        });
//    }

}

