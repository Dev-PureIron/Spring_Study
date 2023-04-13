package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.type.SuperCarType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarDaoTests {

    @Autowired
    private SuperCarDAO superCarDAO;

//    등록
    @Test
    public void saveTest(){
        SuperCar superCar = new SuperCar();
        superCar.setSuperCarName("람보르기니");
        superCar.setSuperCarColor("노란색");
        superCar.setSuperCarPrice(100000000);
        superCar.setType(SuperCarType.LAMBORGHINI);
        superCar.setReleaseDate(LocalDateTime.now());

        superCarDAO.save(superCar);
    }

//    수정
    @Test
    public void setSuperCarTest(){
        SuperCar superCar = new SuperCar();
        superCar.setSuperCarName("람보르기니");
        superCar.setSuperCarColor("노란색");
        superCar.setSuperCarPrice(100000000);
        superCar.setType(SuperCarType.LAMBORGHINI);
        superCar.setReleaseDate(LocalDateTime.now());

        superCarDAO.save(superCar);
        superCar.setSuperCarColor("빨간색");
    }


//    조회
    @Test
    public void findByIdTest(){
        Optional<SuperCar> superCar = superCarDAO.findById(1L);
    }

//    삭제
    @Test
    public void deleteTest(){
        SuperCar superCar3 = new SuperCar();
        superCar3.setSuperCarName("람보르기니");
        superCar3.setSuperCarColor("노란색");
        superCar3.setSuperCarPrice(100000000);
        superCar3.setType(SuperCarType.LAMBORGHINI);
        superCar3.setReleaseDate(LocalDateTime.now());

        superCarDAO.save(superCar3);
        superCarDAO.delete(superCar3);
    }
}
