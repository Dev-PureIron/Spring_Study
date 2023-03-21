package com.example.study.mapper;

import com.example.study.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

//    회원가입
    public void insert(UserVO userVO);

//    로그인

}
