package com.example.jwtproject.auth.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwtproject.auth.jwt.JwtServices;
import com.example.jwtproject.models.UserModel;
import com.example.jwtproject.repository.UserRepositoryImp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Data
public class AuthServices {

    private final JwtServices jwtService; // sericio mio de jwt que contiene logica jwt
    private final PasswordEncoder passwordEncoder; // interfaz de spring security para encriptar las contraseñas
    private final UserRepositoryImp userRepositoryImp; // mi repositorio para verificar en la base de datos
    private final AuthenticationManager authenticationManager; //motor de validacion de authentication
    
    public AuthenticationResponse register(AuthenticationRequest requestUserRegister){
        UserModel userEncripting = new UserModel(requestUserRegister.getId(),requestUserRegister.getUsername(), requestUserRegister.getRol(), passwordEncoder.encode(requestUserRegister.getPassword()));
        userRepositoryImp.saveUser(userEncripting);
        String token = jwtService.generateToken(userEncripting);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse login(AuthenticationRequest requestUserLogin){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(requestUserLogin.getUsername(), requestUserLogin.getPassword())
        );

        UserModel user = userRepositoryImp.findUserByUsername(requestUserLogin.getUsername());
        String token = jwtService.generateToken(user);
        
        return new AuthenticationResponse(token);
    }
}

/**
 *  ┌────────────────────────┐
    │ AuthenticationManager  │ ← motor que valida usuarios
    └────────┬───────────────┘
             ↓
     recibe Authentication (ej: email/pass)
             ↓
     usa AuthenticationProvider (ej: DaoAuthProvider)
             ↓
     obtiene UserDetails desde BD
             ↓
     compara password
             ↓
     retorna Authentication (autenticado)

 */