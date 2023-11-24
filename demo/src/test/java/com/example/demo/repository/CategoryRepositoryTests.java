
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
import org.springframework.security.core.parameters.P;
import org.springframework.test.util.AssertionErrors;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest

public class CategoryRepositoryTests {

    private CategoryService categoryService;

    @Autowired
    public CategoryRepositoryTests(CategoryService categoryService){
        this.categoryService = categoryService;
    }


    // C
    @Test
    public void saveTest(){
        Random random = new Random();

        IntStream.rangeClosed(1, 10).forEach(i->{

            int showRan = random.nextInt(1);
            int dropRan = random.nextInt(1);


            CategoryDTO categoryDTO = CategoryDTO.builder()
                    .cateIdx(Long.valueOf(i))
                    .isShow(String.valueOf(showRan))
                    .isDrop(String.valueOf(dropRan))
                    .content("테스트" + i)
                    .build();

            categoryService.save(categoryDTO);
        });
    }


    // R
    @Test
    public void getLists(){
        assertNotNull(categoryService.getCategoryList());
    }

    // U
    @Test
    public void updateTest(){

        CategoryDTO categoryDTO = CategoryDTO.builder()
                .cateIdx(Long.valueOf(20))
                .content("업데이트")
                .isDrop("0")
                .isShow("0")
                .build();

        categoryService.update(categoryDTO);

    }
    // D
    @Test
    public void deleteTest(){

        IntStream.rangeClosed(1, 10).forEach(i->{
            CategoryDTO categoryDTO = CategoryDTO.builder()
                    .cateIdx(Long.valueOf(i))
                    .build();

            categoryService.delete(categoryDTO);
        });

    }


    @Test
    public void findOneTest(){
        Long idx = 20L;
        Optional<Category> category = categoryService.findOne(idx);
        String content = category.get().getContent();

        assertNull(content);
    }


}

