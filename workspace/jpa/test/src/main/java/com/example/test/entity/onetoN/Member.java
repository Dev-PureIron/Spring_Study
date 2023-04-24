package com.example.test.entity.onetoN;

import com.example.test.audit.Period;
import com.example.test.entity.onetoO.MemberType;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_MEMBER")
public class Member extends Period {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @Column( unique = true)
    @NotNull
    private String email;
    @NotNull private String password;
    @Column( unique = true)
    @NotNull private String phoneNumber;
    @NotNull private String name;
    @NotNull private MemberType status;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Challenge> challenges = new ArrayList<>();
}
