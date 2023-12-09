package com.example.demo.controller;


import com.example.demo.domain.Log;
import com.example.demo.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// 2가지 컨트롤러
// Controller ==> application.properties나 어딘가 설정에 정의되어있는 suffix ==> .html
// RestController ==>
// Restful => HATEOAS

@Slf4j
@Controller
// @RestController
@RequestMapping("/admin")
public class AdminController {


    private final LogService logService;

    @Autowired
    public AdminController(LogService logService){
        this.logService = logService;
    }

    // 쿼리스트링 : ?page=1&sort=descending

    @GetMapping("")
    public String getLogPage(Model model, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC, size = 3) Pageable pageable){

        // Specification<Log> spec = (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("content").get("ip").get("userEmail"), '%' + "테스트" + '%');

        String searchValue = "로그";

        model.addAttribute("logList", logService.getLogList(searchValue, pageable));
        return "admin/index";
    }

    



}
