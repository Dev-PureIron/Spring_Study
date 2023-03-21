package com.example.study.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardVO {

    private Long boardId;
    private Long userId;
    private String boardTitle;
    private String boardContent;
    private String boardRegisterDate;
}
