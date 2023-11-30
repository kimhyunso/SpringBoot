package com.example.demo.domain;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long board_id;

    @Column(name = "is_notice")
    private char is_notice;
    @Column(name = "title")
    private String title;

    @Column(name = "content_normal")
    @Lob
    private String content_normal;

    @Column(name = "content_html")
    @Lob
    private String content_html;

    @Column(name = "is_secret")
    private char is_secret;

    @Column(name = "board_type")
    private String board_type;

    @Column(name = "writer")
    private String writer;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime create_at = LocalDateTime.now();

    @Column(name = "modifyer")
    private String modifyer;

    @Column(name = "modify_at")
    @UpdateTimestamp
    private LocalDateTime modify_at = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<AttachFile> attachFiles = new ArrayList<>();


    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();


    public void convertToDomain(BoardDTO boardDTO){

        setBoard_type(boardDTO.getBoard_type());
        setIs_notice(boardDTO.getIs_notice());
        setTitle(boardDTO.getTitle());
        setContent_normal(boardDTO.getContent_normal());
        setContent_html(boardDTO.getContent_html());
        setWriter(boardDTO.getWriter());
        setIs_secret(boardDTO.getIs_secret());
        setModifyer(boardDTO.getModifyer());
        setCategory(boardDTO.getCategory());
        setMember(boardDTO.getMember());
    }

    public void setCategory(Category category){
        if (this.category != null){
            category.getBoards().remove(this);
        }
        category.getBoards().add(this);
        this.category = category;
    }

    public void setMember(Member member){
        if (this.member != null){
            member.getBoards().remove(this);
        }
        member.getBoards().add(this);
        this.member = member;
    }






}
