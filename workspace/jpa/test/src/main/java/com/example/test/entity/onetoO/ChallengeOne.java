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
@Table( name = "TBL_CHALLENGE")
public class ChallengeOne extends Period {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String title;
    @NotNull private String content;
    @NotNull private ChallengeType status;

}
