package com.example.demo.domain;

import com.example.demo.dto.LogDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Table(name = "log")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long log_id;

    @Column(name = "content")
    private String content;

    @Column(name = "ip")
    private String ip;

    @Column(name = "user_email")
    private String user_email;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime create_at = LocalDateTime.now();

    @Column(name = "modify_at")
    @UpdateTimestamp
    private LocalDateTime modify_at = LocalDateTime.now();


    public void convertToDomain(LogDTO logDTO){
        setLog_id(logDTO.getLog_id());
        setContent(logDTO.getContent());
        setUser_email(logDTO.getUserEmail());
        setIp(logDTO.getIp());
    }
}
