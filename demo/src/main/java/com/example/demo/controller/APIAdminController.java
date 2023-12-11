package com.example.demo.controller;


import com.example.demo.domain.Log;
import com.example.demo.dto.LogDTO;
import com.example.demo.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin")
public class APIAdminController {

    private final LogService logService;

    public APIAdminController(LogService logService){
        this.logService = logService;
    }

    // 1. Specification
    // 2. QueryDSL

    @GetMapping("/v1/api/logs")
    public ResponseEntity<Page<LogDTO>> getLogApi(@PageableDefault(sort = {"createAt"}, direction = Sort.Direction.DESC ,size = 10) Pageable pageable
        , @RequestParam(name = "searchValue", defaultValue = "") String searchValue){

        log.info("pageable Offset={}/ PageSize={}", pageable.getOffset(), pageable.getPageSize());

        return ResponseEntity.ok().body(logService.getLogList(searchValue, pageable));
    }


    @GetMapping("/v1/api/log/{id}")
    public ResponseEntity<Log> getLogFindById(@PathVariable Long id){

        return ResponseEntity.ok().body(logService.findOne(id).get());
    }





}
