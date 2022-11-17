package com.springboot.bbs6.domain.dto;

import lombok.Getter;

@Getter
public class ResponseDto {
    private String username;
    private String message;

    public ResponseDto(String username) {
        this.username = username;
        this.message = "가입이 완료되었습니다.";
    }
}
