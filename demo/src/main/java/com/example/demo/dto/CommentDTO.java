package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CommentDTO {

    private Long commentId;
    private Integer parentId;
    private String comment;
    private String writer;
    private String modifyer;
}
