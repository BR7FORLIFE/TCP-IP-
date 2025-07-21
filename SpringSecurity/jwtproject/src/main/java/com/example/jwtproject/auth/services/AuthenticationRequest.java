package com.example.jwtproject.auth.services;

import com.example.jwtproject.enums.Rol;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AuthenticationRequest {
    private final int id;
    private final String username;
    private final String password;
    private final Rol rol;
}
