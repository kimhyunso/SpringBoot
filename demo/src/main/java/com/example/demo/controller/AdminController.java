package com.example.demo.controller;


import com.example.demo.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// 2가지 컨트롤러
// Controller ==> application.properties나 어딘가 설정에 정의되어있는 suffix ==> .html
// RestController ==>


// Restful => HATEOAS




// TODO: Sort를 사용하면 snake_case 파싱 ==> _(언더바) 사라짐 ==> entity에서 찾지 못함
// 1. SnakeCaseFilter 적용
// 2. Properties에 암묵적, 물리적인 것들을 고정시켜야한다.


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

//
//    @GetMapping("/api/vi/log/{id}")
//    public ResponseEntity<Log> adminTest1(Model model){
//        return ResponseEntity.ok().body(logService.findOne(13L).get());
//    }


    // 쿼리스트링 : ?page=1&sort=descending

    @GetMapping("")
    public String getLogPage(Model model, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC, size = 5) Pageable pageable){

        // descending : 내림차순
        // ascending : 오름차순
        // Sort sort = Sort.by("log_id").descending();

        model.addAttribute("logList", logService.getLogList(pageable));
        // model.addAttribute("pageNo", pageNo);
        // model.addAttribute("pageable", pageable);

        return "admin/index";
    }

    



}
