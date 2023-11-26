
package com.example.demo.repository;

import com.example.demo.domain.Board;
import com.example.demo.domain.Category;
import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.service.BoardService;
import com.example.demo.service.CategoryService;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryRepositoryTests {

    private CategoryService categoryService;

    private BoardService boardService;


    @Autowired
    public CategoryRepositoryTests(CategoryService categoryService, BoardService boardService){
        this.categoryService = categoryService;
        this.boardService = boardService;
    }


    // C
    @Test
    public void saveTest(){
        Random random = new Random();

        IntStream.rangeClosed(1, 10).forEach(i->{

            int showRan = random.nextInt(1);
            int dropRan = random.nextInt(1);


            List<BoardDTO> a = boardService.getBoardList();



            CategoryDTO categoryDTO = CategoryDTO.builder()
                    .cateId(Long.valueOf(i))
                    .isShow(String.valueOf(showRan))
                    .isDrop(String.valueOf(dropRan))
                    .content("테스트" + i)
                    .boardLists(a)
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
                .cateId(Long.valueOf(20))
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

            categoryService.delete(Long.valueOf(i));
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


