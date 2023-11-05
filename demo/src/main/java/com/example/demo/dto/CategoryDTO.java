package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.*;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {

    private Long cateIdx;
    private String content;
    private String isShow;
    private String isDrop;
}
