package com.example.test.audit;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class Period {
    private LocalDateTime RegisterDate;
    private LocalDateTime UpdateDate;

    @PrePersist
    public void create(){
        this.RegisterDate = LocalDateTime.now();
        this.UpdateDate = LocalDateTime.now();
    }

    @PreUpdate
    public void update(){
        this.UpdateDate = LocalDateTime.now();
    }
}
