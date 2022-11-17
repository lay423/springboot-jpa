package com.springboot.bbs6.service;

import com.springboot.bbs6.domain.dto.RequestDto;
import com.springboot.bbs6.domain.dto.ResponseDto;
import com.springboot.bbs6.domain.dto.UserDto;
import com.springboot.bbs6.domain.entity.User;
import com.springboot.bbs6.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUser(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        User user = optUser.get();
        UserDto userDto = user.of(user);
        return userDto;
    }

    public ResponseDto addUser(RequestDto dto) {
        User user = userRepository.save(dto.toEntity());
        return user.ofRes(user);
    }
}
