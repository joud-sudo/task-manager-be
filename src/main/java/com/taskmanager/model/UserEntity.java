package com.taskmanager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "todo_users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME", unique = true, nullable = false)
    private String username;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;
}