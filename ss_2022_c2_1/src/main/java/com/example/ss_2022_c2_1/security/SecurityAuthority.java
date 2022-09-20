package com.example.ss_2022_c2_1.security;

import org.springframework.security.core.GrantedAuthority;

import com.example.ss_2022_c2_1.entities.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {


    private final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getName();
    }
    
}
