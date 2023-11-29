package com.example.demo.repository;

import com.example.demo.domain.AttachFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachRepository extends JpaRepository<AttachFile, Long> {

}
