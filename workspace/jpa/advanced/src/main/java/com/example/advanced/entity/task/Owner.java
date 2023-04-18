package com.example.advanced.entity.task;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table( name = "TBL_OWNER")
public class Owner {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String name;
    @Column(unique = true)
    @NotNull private String phone;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "OWNER_ID")
    List<Pet> pets = new ArrayList<>();
}
