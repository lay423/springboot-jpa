package com.springboot.bbs6.domain.dto;

import lombok.Getter;

@Getter
public class ResponseDto {
    private Long id;
    private String username;
    private String message;

    public ResponseDto(Long id, String username) {
        this.id = id;
        this.username = username;
        this.message = "가입이 완료되었습니다.";
    }
    public ResponseDto(Long id, String username, String message) {
        this.id = id;
        this.username = username;
        this.message = message;
    }
}
