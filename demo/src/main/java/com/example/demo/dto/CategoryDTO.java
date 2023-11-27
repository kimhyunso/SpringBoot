package com.example.demo.dto;

import com.example.demo.domain.Board;
import com.example.demo.domain.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {

    private Long cateId;
    private String content;
    private String isShow;
    private String isDrop;
    private List<Board> boardLists;




}
