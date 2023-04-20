package com.example.expert.repository.board;

import com.example.expert.board.Board;
import com.example.expert.board.Like;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class BoardTests {
    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void saveTest(){
        Board board = new Board();
        Like like1 = new Like();
        Like like2 = new Like();

        board.setBoardTitle("테스트 제목1");
        board.setBoardContent("테스트 내용1");
        board.addLike(like1);
        board.addLike(like2);

        boardDAO.save(board);
    }


    @Test
    public void findByIdTest(){
        boardDAO.findById(12L).map(Board::toString).ifPresent(log::info);
    }

    @Test
    public void findByAllTest(){
        boardDAO.findAll().stream().map(Board::toString).forEach(log::info);
    }


    @Test
    public void deleteTest(){
        boardDAO.findById(15L).ifPresent(board -> {
        boardDAO.deleteLike(board.getLikes().get(0));
        board.getLikes().remove(0);
        });

    }

    @Test
    public void updateTest(){
        boardDAO.findById(15L).ifPresent(board -> board.setBoardTitle("수정 제목2"));
        boardDAO.findById(15L).ifPresent(board -> board.setBoardContent("수정 내용2"));
    }

}













