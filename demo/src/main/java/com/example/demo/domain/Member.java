package com.example.demo.domain;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder(builderMethodName = "MemberBuilder")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name="email")
    private String email;


    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="phone_num")
    private String phoneNum;
    @Column(name="reg_date")
    private Date regDate;
    @Column(name="modify_date")
    private Date modifyDate;
    @Column(name="ip")
    private String ip;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<MemberRole>();

    public void addMemberRole(MemberRole memberRole){
        roleSet.add(memberRole);
    }

    public static MemberBuilder builder(MemberDTO dto) {
        return MemberBuilder()
                .email(dto.getEmail())
                .phoneNum(dto.getPhoneNum())
                .ip(dto.getIp())
                .modifyDate(dto.getModifyDate())
                .password(dto.getPassword())
                .name(dto.getName())
                .regDate(dto.getRegDate());
    }

}
