package com.archives.__basic_crud.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.archives.__basic_crud.models.UserEntity;
import com.archives.__basic_crud.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServices {
    
    private final UserRepository userRepository;

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public Optional<UserEntity> findUserById(int id){
        return userRepository.findById(id);
    }

    public void deleteUser(UserEntity userEntity){
        userRepository.delete(userEntity);
    }

    
}
