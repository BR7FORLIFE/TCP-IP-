package com.test.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @GetMapping("/user")
    public ResponseEntity<ArrayList> getUsers(){
        return ResponseEntity.ok().body(new ArrayList<String>(List.of("bryan", "diaz")));
    }
}
