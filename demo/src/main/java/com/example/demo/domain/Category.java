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
    private String cateIdx;
    @Column(name = "content")
    private String content;
    @Column(name = "is_upper")
    private String isUpper;
    @Column(name = "is_ord")
    private String isOrd;
    @Column(name = "is_show")
    private String isShow;
    @Column(name = "is_drop")
    private String isDrop;

    public static CategoryBuilder builder(CategoryDTO dto) {
        return CategoryBuilder()
                .cateIdx(dto.getCateIdx())
                .content(dto.getContent())
                .isUpper(dto.getIsUpper())
                .isOrd(dto.getIsOrd())
                .isShow(dto.getIsShow())
                .isDrop(dto.getIsDrop());
    }
}
