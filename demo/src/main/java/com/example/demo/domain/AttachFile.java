package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Builder
@Table(name = "attach_file")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AttachFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long file_id;

    @Column(name = "file_name")
    private String file_name;
    @Column(name = "file_size")
    private Integer file_size;
    @Column(name = "org_name")
    private String org_name;
    @Column(name = "down_cnt")
    @ColumnDefault("0")
    private Integer down_cnt;
    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime create_at = LocalDateTime.now();
    @UpdateTimestamp
    @Column(name = "modify_at")
    private LocalDateTime modify_at = LocalDateTime.now();

    public void convertToDomain(){

    }
}
