package com.example.demo.domain;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.collection.spi.PersistentBag;

import java.time.LocalDateTime;
import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
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
    private String phone_num;


    @Column(name="reg_date")
    @CreationTimestamp
    private LocalDateTime reg_date = LocalDateTime.now();


    @Column(name="modify_date")
    @UpdateTimestamp
    private LocalDateTime modify_date = LocalDateTime.now();

    @Column(name="ip")
    private String ip;

    // PersistentBag ==> List
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Board> boards = new ArrayList<Board>();

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<AttachFile> attachFiles = new ArrayList<>();


//    @ElementCollection(fetch = FetchType.LAZY)
//    @Builder.Default
//    private Set<MemberRole> roleSet = new HashSet<MemberRole>();
//
//    public void addMemberRole(MemberRole memberRole){
//        roleSet.add(memberRole);
//    }


    public void convertToDomain(MemberDTO memberDTO){
        setMember_id(memberDTO.getMemberIdx());
        setIp(memberDTO.getIp());
        setName(memberDTO.getName());
        setEmail(memberDTO.getEmail());
        setPhone_num(memberDTO.getPhoneNum());
    }

}
