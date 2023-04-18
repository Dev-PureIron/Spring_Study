package com.example.advanced.entity.task;

import com.example.advanced.repository.task.OwnerDAO;
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
public class OwnerTests {

    @Autowired
    private OwnerDAO ownerDAO;

    @Test
    public void saveTest(){
        Owner owner = new Owner();
        Pet pet = new Pet();

        pet.setName("맥스");
        pet.setGender("암컷");
        pet.setDisease("감기");

        owner.setName("이순철");
        owner.setPhone("010-8915-1820");

        owner.getPets().add(pet);

        ownerDAO.save(owner);
    }

    @Test
    public void findById(){
        ownerDAO.findById(1L).map(Owner::toString).ifPresent(log::info);
    }

    @Test
    public void findByAllTest(){
        ownerDAO.findAll().stream().map(Owner::toString).forEach(log::info);
    }

    @Test
    public void updateTest(){
        ownerDAO.findById(1L).ifPresent(owner -> owner.getPets().get(0).setDisease("다리 관절염"));
    }

    @Test
    public void deleteTest(){
        ownerDAO.findById(1L).ifPresent(ownerDAO::delete);
    }

}
