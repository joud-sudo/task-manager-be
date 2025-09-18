package com.taskmanager.service;

import com.taskmanager.model.Role;
import com.taskmanager.model.UserEntity;
import com.taskmanager.repository.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserEntity registerUser(String username, String password, Role role) {
        if (userRepo.findByUsername(username) != null) {
            throw new RuntimeException("Username is already in use");
        }

        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role != null ? role : Role.USER);

        return userRepo.save(user);
    }

    public UserEntity authenticate(String username, String rawPassword) {
        Optional<UserEntity> userOptional = Optional.ofNullable(userRepo.findByUsername(username));

        if (userOptional.isPresent()) {
            log.info("User {} found in DB", username);
            boolean matches = passwordEncoder.matches(rawPassword, userOptional.get().getPassword());
            log.info("Password match result: {}", matches);
        } else {
            log.warn("User {} not found in DB", username);
        }

        return userOptional
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
                .orElse(null);
    }

}
