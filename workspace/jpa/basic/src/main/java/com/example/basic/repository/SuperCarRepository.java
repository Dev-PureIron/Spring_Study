package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.type.SuperCarType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperCarRepository extends JpaRepository<SuperCar, Long> {

    public List<SuperCar> findByName(String name);
    public List<SuperCar> findByType(SuperCarType type);
    public List<SuperCar> findTop2ByPriceGreaterThanEqualOrderByPriceDesc(int price);

}
