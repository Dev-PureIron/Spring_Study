package com.example.test.entity.onetoO;

import com.example.test.audit.Period;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table( name = "TBL_MEMBER")
public class MemberOne extends Period {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @Column( unique = true)
    @NotNull private String email;
    @NotNull private String password;
    @Column( unique = true)
    @NotNull private String phoneNumber;
    @NotNull private String name;
    @NotNull private MemberType status;

    @OneToOne(fetch = FetchType.LAZY, cascade ={CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "MEMBER_ID")
    private ChallengeOne challenge;
}
