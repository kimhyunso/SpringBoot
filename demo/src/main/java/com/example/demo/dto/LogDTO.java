package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class LogDTO {
    private Long logId;
    private String content;
    private String userEmail;
    private String ip;
}
