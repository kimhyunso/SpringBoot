package com.example.demo.dto;

import com.example.demo.domain.AttachFile;
import com.example.demo.domain.Category;
import com.example.demo.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BoardDTO {

    private Long boardId;
    private char isNotice;
    private String title;
    private String content;
    private String contentHTML;
    private char isSecret;
    private String writer;
    private String modifyer;
    private Category category;
    private Member member;

    private List<AttachFile> attachFiles;

}
