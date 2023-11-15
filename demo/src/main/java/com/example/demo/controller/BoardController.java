package com.example.demo.controller;



import com.example.demo.service.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@RequestMapping("/")
@Controller
public class BoardController {

    private CategoryService categoryService;

    @Autowired
    public BoardController(CategoryService categoryService){
        this.categoryService = categoryService;
    }


    @GetMapping({"/", "list"})
    public String list(Model model){
        // model.addAttribute("categoryList", categoryService.getCategoryList());
        // model.addAttribute("subCategoryList", categoryService.findByIsUpperNotIn(0L));
        return "index";
    }

}
