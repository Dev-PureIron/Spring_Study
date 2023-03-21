package com.example.study.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {

   private Long userId;
   private String userIdentification;
   private String userPassword;
   private String userNickname;
}
