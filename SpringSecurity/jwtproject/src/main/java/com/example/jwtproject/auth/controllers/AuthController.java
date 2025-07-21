package com.example.jwtproject.auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtproject.auth.services.AuthServices;
import com.example.jwtproject.auth.services.AuthenticationRequest;
import com.example.jwtproject.auth.services.AuthenticationResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthServices authServices;
    
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody AuthenticationRequest requestUser){
        AuthenticationResponse response = authServices.register(requestUser);
        return ResponseEntity.ok().body(response);
    }    

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest){
        return null;
    }
}

/**
 * [explicacion]
 * 
 * creamos dos endpoints por seperado del modelo de negocio para hacer el proceso respectivo de spring security
 * 
 * el endpoint pincipal que es api/auth
 * 
 * /register -> aca retornamos en el cuerpo de la respuesta el usuario que ha hecho la peticion y que ha sido registrado, llamammos a authservices para que haga el respectio proceso de registro
 * 
 * /login -> una vez registrado el usuario puede hacer la peticion a /login para revisar su jwt generado y navegas por los endpoints privados
 * 
 */
