package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
@Builder
public class AttachFileDTO {

    private Long fileId;
    private String fileName;
    private Integer fileSize;
    private String orgName;
    private Integer downCnt;



}
