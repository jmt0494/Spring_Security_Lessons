package com.example.ss_2022_c3_e1.config.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.ss_2022_c3_e1.config.security.authentication.CustomAuthentication;
import com.example.ss_2022_c3_e1.config.security.managers.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter{

    private final CustomAuthenticationManager customAuthenticationManager;

    // Step 2 get key from request and pass it to the CustomAuthenticationManager -> CustomAuthenticationManager

    // Step 5 Set the Security context if authenticated -> SecurityConfig
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException {
        // 1. create an authtication object which is not yet authenticated
        String key = String.valueOf(request.getHeader("key"));
        CustomAuthentication ca = new CustomAuthentication(false, key);
        
        // 2. delegate the authentication object to the manager
        // 3. get back the authetication from the manager
        var a = customAuthenticationManager.authenticate(ca);
        
        // 4. if the object is authenicated then send request to the next filter in the chain
        if (a.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request, response);
        }
        
        
    }
    
}
