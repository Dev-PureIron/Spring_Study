package com.example.study.mapper;

import com.example.study.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setUserIdentification("jjg123");
        userVO.setUserPassword("jjg123");
        userVO.setUserNickname("지존지영짱짱");

        userMapper.insert(userVO);
    }

}
