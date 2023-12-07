package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberDTO;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public List<MemberDTO> getMemberList(){
        return memberRepository.findAll().stream()
                .map(member -> {
                    return MemberDTO.builder()
                            .memberId(member.getMemberId())
                            .ip(member.getIp())
                            .phoneNum(member.getPhoneNum())
                            .name(member.getName())
                            .email(member.getEmail())
                            .build();
                }).collect(Collectors.toList());
    }


    @Transactional
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }





    @Transactional
    public void save(MemberDTO memberDTO){
        duplicateEmail(memberDTO.getEmail());

        Member member = new Member();
        member.convertToDomain(memberDTO);

        memberRepository.save(member);
    }


    @Transactional
    public void update(MemberDTO memberDTO){
        findOne(memberDTO.getMemberId()).ifPresent(member -> {
            member.convertToDomain(memberDTO);
        });
    }


    @Transactional
    public void delete(Long memberId){
        memberRepository.deleteById(memberId);
    }

    @Transactional
    public long count(){
        return memberRepository.count();
    }




    @Transactional
    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    protected void duplicateEmail(String email){
        findByEmail(email).ifPresent(findMember ->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


}
