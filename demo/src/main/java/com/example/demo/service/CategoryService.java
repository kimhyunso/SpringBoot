package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

        private final CategoryRepository repository;

        @Autowired
        public CategoryService(CategoryRepository repository){
                this.repository = repository;
        }

        @Transactional(readOnly = true)
        public List<CategoryDTO> getCategoryList(){
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

        public List<CategoryDTO> findByIsUpperNotIn(Long idx){
                return repository.findByIsUpperNotIn(idx).stream()
                        .map(category -> {
                                return CategoryDTO.builder()
                                        .cateIdx(category.getCate_idx())
                                        .isDrop(category.getIs_drop())
                                        .isShow(category.getIs_show())
                                        .content(category.getContent())
                                        .build();

                        }).collect(Collectors.toList());
        }

}
