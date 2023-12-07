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

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    // C
    @Transactional(readOnly = true)
    public List<BoardDTO> getBoardList(){


        return boardRepository.findAll().stream()
                .map(board ->{
                    return BoardDTO.builder()
                            .boardId(board.getBoardId())
                            .content(board.getContent())
                            .contentHTML(board.getContentHTML())
                            .isNotice(board.getIsNotice())
                            .title(board.getTitle())
                            .writer(board.getWriter())
                            .isSecret(board.getIsSecret())
                            .modifyer(board.getModifyer())
                            .build();
                }).collect(Collectors.toList());

    }

    // R
    @Transactional
    public void save(BoardDTO boardDTO){
        Board board = new Board();
        board.convertToDomain(boardDTO);

        boardRepository.save(board);
    }

    @Transactional
    public Optional<Board> findOne(Long board_id){
        return boardRepository.findById(board_id);
    }


    // U
    @Transactional
    public void update(BoardDTO boardDTO){
        findOne(boardDTO.getBoardId()).ifPresent(findBoard->{
            findBoard.convertToDomain(boardDTO);
        });
    }

    @Transactional
    public void delete(Long board_id){
        boardRepository.deleteById(board_id);
    }

    @Transactional
    public long count(){
        return boardRepository.count();
    }

}
