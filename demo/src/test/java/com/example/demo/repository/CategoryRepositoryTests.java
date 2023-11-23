
package com.example.demo.repository;

import com.example.demo.domain.Category;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.util.AssertionErrors;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
public class CategoryRepositoryTests {

    private CategoryService categoryService;

    @Autowired
    public CategoryRepositoryTests(CategoryService categoryService){
        this.categoryService = categoryService;
    }


    @Test
    public void getLists(){
        Assertions.assertNotNull(categoryService.getCategoryList());
    }

//    @Test
//    public void saveTest(){
//
//        Random rand = new Random();
//
//        IntStream.rangeClosed(6, 10).forEach(i->{
//
//            CategoryDTO categoryDTO = CategoryDTO.builder()
//                    .content("테스트" + i)
//                    .isShow("1")
//                    .isDrop("1")
//                    .build();
//
//            Category category = Category.builder(categoryDTO).build();
//            categoryService.getCategoryList();
//        });
//    }
//
//    @Test
//    public void selectNotIn(){
//
//        // System.out.println(repository.findByIsUpperNotIn(0L));
//
//    }


}

