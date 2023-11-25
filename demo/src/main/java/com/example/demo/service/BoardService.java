package com.example.demo.service;


import com.example.demo.domain.Board;
import com.example.demo.dto.BoardDTO;
import com.example.demo.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
public class BoardService {

    private final BoardRepository repository;

    @Autowired
    public BoardService(BoardRepository repository){
        this.repository = repository;
    }

    // C
    @Transactional(readOnly = true)
    public List<BoardDTO> getBoardList(){


        return repository.findAll().stream()
                .map(board ->{
                    return BoardDTO.builder()
                            .board_id(board.getBoard_id())
                            .board_type(board.getBoard_type())
                            .content_html(board.getContent_html())
                            .content_normal(board.getContent_normal())
                            .is_notice(board.getIs_notice())
                            .title(board.getTitle())
                            .writer(board.getWriter())
                            .is_secret(board.getIs_secret())
                            .modifyer(board.getModifyer())
                            .build();
                }).collect(Collectors.toList());

    }

    // R
    @Transactional
    public void save(BoardDTO boardDTO){
        Board board = Board.builder()
                .board_id(boardDTO.getBoard_id())
                .board_type(boardDTO.getBoard_type())
                .content_html(boardDTO.getContent_html())
                .content_normal(boardDTO.getContent_normal())
                .is_notice(boardDTO.getIs_notice())
                .title(boardDTO.getTitle())
                .writer(boardDTO.getWriter())
                .is_secret(boardDTO.getIs_secret())
                .modifyer(boardDTO.getModifyer())
                .build();

        repository.save(board);
    }

    @Transactional
    public Optional<Board> findOne(Long board_id){
        return repository.findById(board_id).stream().findFirst();
    }


    // U
    @Transactional
    public void update(BoardDTO boardDTO){
        findOne(boardDTO.getBoard_id()).get().update(boardDTO);
    }

    @Transactional
    public void delete(Long board_id){
        repository.delete(findOne(board_id).get());
    }



}
