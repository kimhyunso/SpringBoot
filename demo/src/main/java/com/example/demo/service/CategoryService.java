package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryService {

        private final CategoryRepository repository;

        @Autowired
        public CategoryService(CategoryRepository repository){
                this.repository = repository;
        }

        @Transactional(readOnly = true)
        public List<Category> getCategoryList(){
            return repository.findAll();
        }

        public List<Category> findByIsUpperNotIn(Long idx){
                return repository.findByIsUpperNotIn(idx);
        }

}
