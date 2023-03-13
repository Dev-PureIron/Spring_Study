package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonVO {
    private String name;
    private int age;
    private String gender;
}
