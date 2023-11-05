package com.example.demo.domain;

import com.example.demo.dto.CategoryDTO;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder(builderMethodName = "CategoryBuilder")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_idx")
    private Long cate_idx;
    @Column(name = "content")
    private String content;
    @Column(name = "is_show")
    private String is_show;
    @Column(name = "is_drop")
    private String is_drop;

    public static CategoryBuilder builder(CategoryDTO dto) {
        return CategoryBuilder()
                .cate_idx(dto.getCateIdx())
                .content(dto.getContent())
                .is_show(dto.getIsShow())
                .is_drop(dto.getIsDrop());

    }
}
