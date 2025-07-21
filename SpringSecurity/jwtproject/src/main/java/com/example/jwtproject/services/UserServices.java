package com.example.jwtproject.services;

import org.springframework.stereotype.Service;

import com.example.jwtproject.repository.UserRepositoryImp;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServices{
    private final UserRepositoryImp userImp;
}
