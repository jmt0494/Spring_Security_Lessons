package com.example.ss_2022_c3_e1.config.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.ss_2022_c3_e1.config.providers.ApiKeyProvider;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager{

    private final String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var provider = new ApiKeyProvider(key);
        if (provider.supports(authentication.getClass())) {
            return provider.authenticate(authentication);
        }
        return authentication;  
    }
    
}
