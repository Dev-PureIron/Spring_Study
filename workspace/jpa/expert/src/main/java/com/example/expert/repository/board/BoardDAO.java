package com.example.expert.repository.board;

import com.example.expert.board.Board;
import com.example.expert.board.Like;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BoardDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public Board save(Board board){
        entityManager.persist(board);
        return board;
    }

//    조회
    public Optional<Board> findById(Long id){
        return Optional.ofNullable(entityManager.find(Board.class, id));
//        String query = "select b from Board b join fetch b.likes where b.id =: id";
//        return Optional.ofNullable(entityManager.createQuery(query, Board.class).setParameter("id", id).getSingleResult());
    }

//    전체 조회
    public List<Board> findAll(){
        String query = "select b from Board b join fetch b.likes";
        return entityManager.createQuery(query, Board.class).getResultList();
    }

//    삭제
    public void deleteBoard(Board board){
        entityManager.remove(board);
    }

    public void deleteLike(Like like){
        entityManager.remove(like);
    }

}
