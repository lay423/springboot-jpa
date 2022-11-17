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
        if (optUser.isEmpty()) {
            return new ResponseDto(id, "", "해당 id의 유저가 없습니다");
        } else {
            User user = optUser.get();
            return User.of(user, "찾았습니다.");
        }

    }

    public ResponseDto addUser(RequestDto dto) {
        User user = userRepository.save(dto.toEntity());
        return User.of(user);
    }
}
