package com.example.demo.dto;

import com.example.demo.domain.Category;
import com.example.demo.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BoardDTO {
    private Long board_id;
    private char is_notice;
    private String title;
    private String content_normal;
    private String content_html;
    private char is_secret;
    private String board_type;
    private String writer;
    private String modifyer;
    private Category category;
    private Member member;
}
