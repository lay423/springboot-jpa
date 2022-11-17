package com.springboot.bbs6.controller;

import com.springboot.bbs6.domain.dto.RequestDto;
import com.springboot.bbs6.domain.dto.ResponseDto;
import com.springboot.bbs6.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class ArticleController {

    private final UserService userService;

    public ArticleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable Long id) {
        ResponseDto responseDto = userService.getUser(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> addUser(@RequestBody RequestDto dto) {
        log.info("dto={}", dto);
        ResponseDto responseDto = userService.addUser(dto);
        log.info("name={} messgae={}", responseDto.getUsername(), responseDto.getMessage());
        return ResponseEntity.ok().body(responseDto);
    }
}
