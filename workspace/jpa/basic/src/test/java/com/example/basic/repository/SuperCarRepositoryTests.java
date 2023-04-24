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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class SuperCarRepositoryTests {
    @Autowired
    private SuperCarRepository superCarRepository;

    @Test
    public void saveTest(){
        SuperCar superCar1 = SuperCar.builder()
                .name("제네시스")
                .color("검정색")
                .price(200000000.0)
                .releaseDate(LocalDateTime.now())
                .type(SuperCarType.HYUNDAI)
                .build();

        SuperCar superCar2 = SuperCar.builder()
                .name("구아방")
                .color("노란색")
                .price(5000000.0)
                .releaseDate(LocalDateTime.now())
                .type(SuperCarType.HYUNDAI)
                .build();

        SuperCar superCar3 = SuperCar.builder()
                .name("람보르기히이히니")
                .color("노란색")
                .price(150000000.0)
                .releaseDate(LocalDateTime.now())
                .type(SuperCarType.LAMBORGHINI)
                .build();

        SuperCar superCar4 = SuperCar.builder()
                .name("벤틀리에는 무슨차가있나요?")
                .color("검정색")
                .price(150000000.0)
                .releaseDate(LocalDateTime.now())
                .type(SuperCarType.BENTLEY)
                .build();

        List<SuperCar> superCars = new ArrayList<>(Arrays.asList(superCar1, superCar2, superCar3, superCar4));

        superCarRepository.saveAll(superCars);
    }

    @Test
    public void findByIdTest(){
        superCarRepository.findById(20L).ifPresent(superCar -> log.info(superCar.getName()));
    }



}
