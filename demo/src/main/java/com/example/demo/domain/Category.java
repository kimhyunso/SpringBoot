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

    // IDENTITY = mariadb
    // autoincrement 자동으로 증가를 해주면 IDENTITY MARIADB==
    // SEQUENCE = oracle, mariadb
    // sequence를 생성해서 증가하는 방식을 사용할 경우 사용하게 됩니다.
    // TABLE = DB
    // tableA, tableB만들어서 (자동으로 만들어줄 수 있게끔 설정) tableB에 의해서 tableA에 primary key
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


    // 디자인 패턴
    // Builder == 가독성을 좋게하기위해서
    // setter, getter
    // Category category = new Category();
    // category.setCate_idx();
    // category.setCate_idx();
    // category.setContent();
    // category.setIsShow();

    public static CategoryBuilder builder(CategoryDTO dto) {
        return CategoryBuilder()
                .cate_idx(dto.getCateIdx())
                .content(dto.getContent())
                .is_show(dto.getIsShow())
                .is_drop(dto.getIsDrop());

    }
}
