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
        Board board = new Board();
        board.convertToDomain(boardDTO);

        repository.save(board);
    }

    @Transactional
    public Optional<Board> findOne(Long board_id){
        return repository.findById(board_id);
    }


    // U
    @Transactional
    public void update(BoardDTO boardDTO){
        findOne(boardDTO.getBoard_id()).ifPresent(findBoard->{
            findBoard.convertToDomain(boardDTO);
        });
    }

    @Transactional
    public void delete(Long board_id){
        repository.deleteById(board_id);
    }



}
