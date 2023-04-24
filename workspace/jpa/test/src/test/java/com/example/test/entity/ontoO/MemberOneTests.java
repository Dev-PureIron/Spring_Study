package com.example.test.entity.ontoO;

import com.example.test.entity.onetoO.ChallengeOne;
import com.example.test.entity.onetoO.MemberOne;
import com.example.test.entity.onetoO.MemberType;
import com.example.test.repositroy.onetoO.MemberOneDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class MemberOneTests {
    @Autowired
    private MemberOneDAO memberOneDAO;

    @Test
    public void saveTest(){
        MemberOne member1 = new MemberOne();
        ChallengeOne challenge1 = new ChallengeOne();

        challenge1.setTitle("테스트 제목1");
        challenge1.setContent("테스트 내용1");

        member1.setEmail("lsc00@gmail.com");
        member1.setPassword("1234");
        member1.setPhoneNumber("010-8915-1820");
        member1.setStatus(MemberType.MEMBERSHIP);

        memberOneDAO.save(member1);

    }

    @Test
    public void findByIdTest(){
        memberOneDAO.findById(1L).map(MemberOne::toString).ifPresent(log::info);
    }

    @Test
    public void findAllTest(){
        memberOneDAO.findAll().stream().map(MemberOne::toString).forEach(log::info);
    }
    @Test
    public void delete(){
        memberOneDAO.findById(1L).ifPresent(memberOneDAO::delete);
    }

}
