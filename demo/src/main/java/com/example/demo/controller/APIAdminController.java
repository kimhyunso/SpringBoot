package com.example.demo.controller;


import com.example.demo.domain.Log;
import com.example.demo.dto.LogDTO;
import com.example.demo.service.LogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class APIAdminController {

    private final LogService logService;

    public APIAdminController(LogService logService){
        this.logService = logService;
    }

    @GetMapping("/api/v1")
    public ResponseEntity<Page<LogDTO>> getLogApi(@PageableDefault(sort = {"log_id"}, direction = Sort.Direction.DESC ,size = 10) Pageable pageable){


        return ResponseEntity.ok().body(logService.getLogList(pageable));
    }





}
