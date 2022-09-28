package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.httpBasic()
            .and()
            .authorizeRequests()
            /* Matching */
                // .anyRequest() // catches all requests
                .mvcMatchers("/demo").hasAuthority("read")
                .mvcMatchers().authenticated()


            /* Authorities */
                // .authenticated() // anyone logged in
                // .permitAll() // anyone not logged in or logged in with a valid user
                // .denyAll() // blocks all access
                // .hasAuthority("read") // anyone with the authority named
                // .hasAnyAuthority("read", "write") // anyone with any of the authorities named
                // .hasRole("ADMIN") // same as .hasAuthority("ROLE_ADMINE")
                // .hasAnyRole("ADMIN", "MANAGER")
                // .access("isAuthenticated() and hasAuthority('read')") // uses spring expression language (SpEL)
            .and().build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("bill")
            .password(passwordEncoder().encode("12345"))
            .authorities("read")
            // .roles("ADMIN")
            .build();

        var u2 = User.withUsername("john")
            .password(passwordEncoder().encode("12345"))
            .authorities("write")
            // .roles("MANAGER")
            .build();

        uds.createUser(u1);
        uds.createUser(u2);

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
