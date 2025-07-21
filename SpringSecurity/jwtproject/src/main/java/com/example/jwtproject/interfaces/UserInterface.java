package com.example.jwtproject.interfaces;

import java.util.List;

import com.example.jwtproject.models.UserModel;

public interface UserInterface {
    List<UserModel> getUsers();
    UserModel saveUser(UserModel userModel);
    UserModel findUserByUsername(String username);
}
