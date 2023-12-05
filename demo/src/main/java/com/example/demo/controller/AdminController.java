package com.example.demo.controller;


import com.example.demo.domain.Log;
import com.example.demo.dto.LogDTO;
import com.example.demo.dto.PageResultDTO;
import com.example.demo.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
// 2가지 컨트롤러
// Controller ==> application.properties나 어딘가 설정에 정의되어있는 suffix ==> .html
// RestController ==>


// Restful => HATEOAS



// TODO: 페이징처리 및 테스트 / Sort properties 에러 확인하기
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


//    @GetMapping("/api/v1/")
//    public ResponseEntity<List<LogDTO>> adminCategory(Model model){
//
//        Pageable pageable = PageRequest.of(0, 5);
//
//        return ResponseEntity.ok().body(logService.getLogList(pageable));
//    }
//
//    @GetMapping("/api/vi/log/{id}")
//    public ResponseEntity<Log> adminTest1(Model model){
//        return ResponseEntity.ok().body(logService.findOne(13L).get());
//    }


    // 쿼리스트링 : ?page=1&sort=descending

    @GetMapping("")
    public String getLogPage(Model model){


        // descending : 내림차순
        // ascending : 오름차순
        // Sort sort = Sort.by("log_id").descending();

        Pageable pageable = PageRequest.of(0, 10);
        model.addAttribute("logList", logService.getLogList(pageable));
        // model.addAttribute("pageNo", pageNo);
        // model.addAttribute("pageable", pageable);

        return "admin/index";
    }

    



}
