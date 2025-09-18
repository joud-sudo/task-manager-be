package com.taskmanager.dto;

import com.taskmanager.model.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String token;
}
