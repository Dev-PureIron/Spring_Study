package com.example.test.repositroy.onetoO;

import com.example.test.entity.onetoO.MemberOne;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberOneDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public MemberOne save(MemberOne member){
        entityManager.persist(member);
        return member;
    }

//    조회
    public Optional<MemberOne> findById(Long id){
        String query = "select m from MemberOne m join fetch m.challenge where m.id = :id";
        return Optional.ofNullable(entityManager.createQuery(query, MemberOne.class).setParameter("id", id).getSingleResult());
    }

//    전체 조회
    public List<MemberOne> findAll(){
        String query ="select m from MemberOne m join fetch m.challenge";
        return entityManager.createQuery(query, MemberOne.class).getResultList();
    }
//    삭제
    public void delete(MemberOne member){
        entityManager.remove(member);
    }
}
