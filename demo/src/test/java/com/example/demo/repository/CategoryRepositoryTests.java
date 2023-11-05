/*
package com.example.demo.repository;

import com.example.demo.domain.Category;
import com.example.demo.dto.CategoryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
public class CategoryRepositoryTests {

    private final CategoryRepository repository;

    @Autowired
    public CategoryRepositoryTests(CategoryRepository repository){
        this.repository = repository;
    }

    @Test
    public void saveTest(){
        Random rand = new Random();

        IntStream.rangeClosed(6, 10).forEach(i->{

            CategoryDTO dto = new CategoryDTO();
            dto.setContent("테스트"+ i);
            dto.setIsShow("1");
            dto.setIsDrop("1");

            Category category = Category.builder(dto).build();
            repository.save(category);
        });
    }

    @Test
    public void selectNotIn(){

        System.out.println(repository.findByIsUpperNotIn(0L));

    }





}
*/
