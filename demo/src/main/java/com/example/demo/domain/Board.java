package com.example.demo.domain;

import com.example.demo.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_at;

    @Column(name = "modifyer")
    private String modifyer;

    @Column(name = "modify_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modify_at;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void update(BoardDTO boardDTO){
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
