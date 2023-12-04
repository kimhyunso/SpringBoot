package com.example.demo.controller;


import com.example.demo.domain.Log;
import com.example.demo.dto.LogDTO;
import com.example.demo.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

// 2가지 컨트롤러
// Controller ==> application.properties나 어딘가 설정에 정의되어있는 suffix ==> .html
// RestController ==>


// Restful => HATEOAS


@Slf4j
@Controller
//@RestController
@RequestMapping("/admin")
public class AdminController {


    private final LogService logService;

    @Autowired
    public AdminController(LogService logService){
        this.logService = logService;
    }


//    @GetMapping("/api/v1/")
//    public ResponseEntity<List<LogDTO>> adminCategory(Model model){
//        return ResponseEntity.ok().body(logService.getLogList());
//    }
//
//    @GetMapping("/api/vi/log/{id}")
//    public ResponseEntity<Log> adminTest1(Model model){
//        return ResponseEntity.ok().body(logService.findOne(13L).get());
//    }

    @GetMapping("")
    public String getLogPage(Model model){

        model.addAttribute("logList", logService.getLogList());

        return "admin/index";
    }

    



}
