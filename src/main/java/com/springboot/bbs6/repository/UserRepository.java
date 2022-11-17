package com.springboot.bbs6.repository;

import com.springboot.bbs6.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
