package com.springboot.bbs6.service;

import com.springboot.bbs6.domain.dto.RequestDto;
import com.springboot.bbs6.domain.dto.ResponseDto;
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

    public ResponseDto getUser(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        User user = optUser.get();
        ResponseDto responseDto = user.of(user, "찾았습니다.");
        return responseDto;
    }

    public ResponseDto addUser(RequestDto dto) {
        User user = userRepository.save(dto.toEntity());
        return user.of(user);
    }
}
