package com.example.ss_2022_c3_e1.config.security.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.ss_2022_c3_e1.config.security.providers.CustomAuthenticationProvider;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager{

    private final CustomAuthenticationProvider provider;

    // Step 3 Call the CustomAuthenticationProvider to Authenticate -> CustomAuthenticationProvider
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        if( provider.supports(authentication.getClass())) {
            return provider.authenticate(authentication);
        }
        
        throw new BadCredentialsException("Oh No! Authentication Method Not Supported");
    }
    
}
