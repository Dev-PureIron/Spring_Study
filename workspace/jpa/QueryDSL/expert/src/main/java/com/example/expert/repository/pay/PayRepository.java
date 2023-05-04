package com.example.expert.repository.pay;

import com.example.expert.entity.pay.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay, Long>, PayQueryDsl {
}
