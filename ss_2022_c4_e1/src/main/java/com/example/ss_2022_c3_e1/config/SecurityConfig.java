package com.example.ss_2022_c3_e1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.ss_2022_c3_e1.config.filter.ApiKeyFilter;

@Configuration
public class SecurityConfig {
    
    @Value("${the.secret}")
    private String key;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.httpBasic()
            .and()
            .addFilterBefore(new ApiKeyFilter(key), BasicAuthenticationFilter.class)
            .authorizeRequests().anyRequest().authenticated()
            .and().build();
    }


}
