package com.example.jwtproject.models;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.jwtproject.enums.Rol;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserModel implements UserDetails {
    private final Integer id;
    private final String name;
    private final Rol rol;
    private final String password;
    private List<Rol> rols;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return rols.stream().map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.name())).collect(Collectors.toList());
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername(){
        return name;
    }
}
