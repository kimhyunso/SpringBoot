package com.example.demo.controller;


import com.example.demo.domain.Log;
import com.example.demo.dto.LogDTO;
import com.example.demo.service.LogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class APIAdminController {

    private final LogService logService;

    public APIAdminController(LogService logService){
        this.logService = logService;
    }

    @GetMapping("/v1/api/logs")
    public ResponseEntity<Page<LogDTO>> getLogApi(@PageableDefault(sort = {"createAt"}, direction = Sort.Direction.DESC ,size = 3) Pageable pageable){
        Specification<Log> spec = Specification
                .where((Specification<Log>)(root, query, criteriaBuilder) -> criteriaBuilder.isNotEmpty())
                .and((Specification<Log>)(root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("ip"), '%' + "유저이름1" + '%'))
                .and((Specification<Log>)(root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("userEmail"), '%' + "유저이름1" + '%'))
                .and((Specification<Log>)(root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("content"), '%' + "유저이름1" + '%'));



        return ResponseEntity.ok().body(logService.getLogList(pageable, spec));
    }


    @GetMapping("/v1/api/log/{id}")
    public ResponseEntity<Log> getLogFindById(@PathVariable Long id){

        return ResponseEntity.ok().body(logService.findOne(id).get());
    }





}
