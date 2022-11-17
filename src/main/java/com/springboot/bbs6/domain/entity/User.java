package com.springboot.bbs6.domain.entity;

import com.springboot.bbs6.domain.dto.ResponseDto;
import com.springboot.bbs6.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;

    public static UserDto of(User user) {
        return new UserDto(user.getId(), user.getUsername());
    }

    public static ResponseDto ofRes(User user) {
        return new ResponseDto(user.getUsername());
    }
}
