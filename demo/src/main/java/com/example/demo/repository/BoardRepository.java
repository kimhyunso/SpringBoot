package com.example.demo.repository;

import com.example.demo.domain.Board;
import com.example.demo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByCategory(Category category);
}
