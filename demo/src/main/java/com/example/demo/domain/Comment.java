package com.example.demo.domain;

import com.example.demo.dto.CommentDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDateTime;


@Table(name = "comment")
@Entity
@AllArgsConstructor
@Setter
@Getter
@Builder
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long comment_id;

    @Column(name = "parent_id")
    private Integer parent_id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "writer")
    private String writer;

    @Column(name = "modifyer")
    private String modifyer;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime create_at = LocalDateTime.now();

    @Column(name = "modify_at")
    @UpdateTimestamp
    private LocalDateTime modify_at = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    public void setBoard(Board board) {
        if (this.board != null){
            board.getComments().remove(this);
        }
        board.getComments().add(this);
        this.board = board;
    }

    public void setMember(Member member) {
        if (this.member != null){
            member.getComments().remove(this);
        }
        member.getComments().add(this);
        this.member = member;
    }

    public void convertToDomain(CommentDTO commentDTO){
        setComment_id(commentDTO.getCommentId());
        setParent_id(commentDTO.getParentId());
        setComment(commentDTO.getComment());
        setWriter(commentDTO.getWriter());
        setBoard(commentDTO.getBoard());
        setMember(commentDTO.getMember());
        setModifyer(commentDTO.getModifyer());
    }
}
