package com.example.demo.domain;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name = "MEMBER")
@Builder(builderMethodName = "MemberBuilder")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column(name = "email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="phone_num")
    private String phoneNum;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="reg_date")
    private Date regDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modify_date")
    private Date modifyDate;

    @Column(name="ip")
    private String ip;

    @OneToMany(mappedBy = "member")
    private ArrayList<Board> boards = new ArrayList<Board>();


    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<MemberRole>();

    public void addMemberRole(MemberRole memberRole){
        roleSet.add(memberRole);
    }

    public static MemberBuilder builder(MemberDTO dto) {
        return MemberBuilder()
                .member_id(dto.getMemberIdx())
                .email(dto.getEmail())
                .phoneNum(dto.getPhoneNum())
                .ip(dto.getIp())
                .password(dto.getPassword())
                .name(dto.getName());
    }

}
