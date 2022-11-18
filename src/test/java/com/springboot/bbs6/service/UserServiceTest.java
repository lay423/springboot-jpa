package com.springboot.bbs6.service;

import com.springboot.bbs6.domain.dto.RequestDto;
import com.springboot.bbs6.domain.dto.ResponseDto;
import com.springboot.bbs6.domain.entity.User;
import com.springboot.bbs6.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserServiceTest {

    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    private UserService userService;

    @BeforeEach
    void setUp(){
        userService = new UserService(userRepository);  //수동 DI

    }

    @Test
    @DisplayName("등록되었는지 test")
    void addTest() {
        Mockito.when(userRepository.save(any()))
                .thenReturn(new User(1L, "junha", "21232"));

        ResponseDto responseDto = userService.addUser(new RequestDto("junha", "21232"));
        assertEquals("가입이 완료되었습니다.", responseDto.getMessage());

    }
}