package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.domain.Category;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final BoardRepository boardRepository;

    public CategoryService(CategoryRepository categoryRepository, BoardRepository boardRepository) {
        this.categoryRepository = categoryRepository;
        this.boardRepository = boardRepository;
    }


    @Transactional(readOnly = true)
    public List<CategoryDTO> getCategoryList() {

        // 1. stream filter
        // 2. findAllById

        return categoryRepository.findAll().stream()
                .map(category -> {


                  

                    List<Board> a = boardRepository.findAllByCategory(category);


                    return CategoryDTO.builder()
                            .cateId(category.getCate_id())
                            .isDrop(category.getIs_drop())
                            .isShow(category.getIs_show())
                            .content(category.getContent())
                            // .boardLists(boardRepository.findAllByCategory(category))
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
                .cate_id(categoryDTO.getCateId())
                .content(categoryDTO.getContent())
                .build();
        category.setBoards(boardRepository.findAllByCategory(category));

        categoryRepository.save(category);
    }

    @Transactional
    public void update(CategoryDTO categoryDTO){
        Optional<Category> category = findOne(categoryDTO.getCateId());

        if (category.isPresent())
            category.get().update(categoryDTO);
    }


    @Transactional
    public void delete(Long category_id){
        if (findOne(category_id).isPresent())
            categoryRepository.delete(findOne(category_id).get());
    }

    @Transactional
    public Optional<Category> findOne(Long idx){
        return categoryRepository.findById(idx).stream().findFirst();
    }

}
