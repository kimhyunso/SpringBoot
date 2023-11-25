package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> getCategoryList() {
        return repository.findAll().stream()
                .map(category -> {
                    return CategoryDTO.builder()
                            .cateIdx(category.getCate_idx())
                            .isDrop(category.getIs_drop())
                            .isShow(category.getIs_show())
                            .content(category.getContent())
                            .build();
                }).collect(Collectors.toList());
    }

    // JPQL
//    public List<CategoryDTO> findByIsUpperNotIn(Long idx) {
//        return repository.findByIsUpperNotIn(idx).stream()
//                .map(category -> {
//                    return CategoryDTO.builder()
//                            .cateIdx(category.getCate_idx())
//                            .isDrop(category.getIs_drop())
//                            .isShow(category.getIs_show())
//                            .content(category.getContent())
//                            .build();
//
//                }).collect(Collectors.toList());
//    }

    @Transactional
    public void save(CategoryDTO categoryDTO) {
        Category category = Category.CategoryBuilder()
                .is_drop(categoryDTO.getIsDrop())
                .is_show(categoryDTO.getIsShow())
                .cate_idx(categoryDTO.getCateIdx())
                .content(categoryDTO.getContent())
                .build();

        repository.save(category);
    }

    @Transactional
    public void update(CategoryDTO categoryDTO){
        Optional<Category> category = findOne(categoryDTO.getCateIdx());

        if (category.isPresent())
            category.get().update(categoryDTO);
    }


    @Transactional
    public void delete(Long category_id){
        if (findOne(category_id).isPresent())
            repository.delete(findOne(category_id).get());
    }

    @Transactional
    public Optional<Category> findOne(Long idx){
        return repository.findById(idx).stream().findFirst();
    }

}
