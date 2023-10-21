package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.*;




@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {


    private String cateIdx;
    private String content;
    private String isUpper;
    private String isOrd;
    private String isShow;
    private String isDrop;
}
