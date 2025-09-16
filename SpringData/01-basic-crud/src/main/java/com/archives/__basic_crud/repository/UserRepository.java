package com.archives.__basic_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archives.__basic_crud.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
}
