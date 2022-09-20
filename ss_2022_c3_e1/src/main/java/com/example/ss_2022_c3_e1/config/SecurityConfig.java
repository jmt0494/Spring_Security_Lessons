package com.example.ss_2022_c3_e1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.ss_2022_c3_e1.config.security.filters.CustomAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    

    private final CustomAuthenticationFilter customAuthenticationFilter;

    // step 1 add filter to filter chain -> CustomAuthenticationFilter

    // step 6 Delegate to the next filter -> eventually this will hit the authorize filter (not impelemted in this project).
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
            .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests().anyRequest().authenticated()
            .and().build();
    }
}
