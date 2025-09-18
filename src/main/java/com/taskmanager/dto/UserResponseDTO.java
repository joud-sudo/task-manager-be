package com.taskmanager.dto;

import com.taskmanager.model.Role;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDTO {
    private Long id;
    private String username;
    private Role role;

    public UserResponseDTO(Long id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }
}