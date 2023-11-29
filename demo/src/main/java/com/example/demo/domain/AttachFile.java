package com.example.demo.domain;

import com.example.demo.dto.AttachFileDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Builder
@Table(name = "attach_file")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AttachFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long file_id;

    @Column(name = "file_name")
    private String file_name;
    @Column(name = "file_size")
    private Integer file_size;
    @Column(name = "org_name")
    private String org_name;

    // 생성되는 시점에서 발동됨
    // @ColumnDefault("0")

    @Column(name = "down_cnt")
    private Integer down_cnt;

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime create_at = LocalDateTime.now();
    @UpdateTimestamp
    @Column(name = "modify_at")
    private LocalDateTime modify_at = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void convertToDomain(AttachFileDTO dto){
        setFile_id(dto.getFileId());
        setFile_name(dto.getFileName());
        setOrg_name(dto.getOrgName());
        setFile_size(dto.getFileSize());
        setDown_cnt(dto.getDownCnt() == null ? 0 : dto.getDownCnt());
        setBoard(dto.getBoard());
        setMember(dto.getMember());
    }

    public void setMember(Member member){
        if (this.member != null){
            member.getAttachFiles().remove(this);
        }
        member.getAttachFiles().add(this);
        this.member = member;
    }

    public void setBoard(Board board){
        if (this.board != null){
            board.getAttachFiles().remove(this);
        }
        board.getAttachFiles().add(this);
        this.board = board;
    }

}
