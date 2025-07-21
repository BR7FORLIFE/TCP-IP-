package com.example.jwtproject.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwtproject.repository.UserRepositoryImp;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsImp implements UserDetailsService {
    private final UserRepositoryImp userImp;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return userImp.getUsers().stream()
            .filter(user -> user.getName().equals(username))
            .findFirst()
            .orElseThrow(() -> new UsernameNotFoundException("username not found!"));
    }
}
