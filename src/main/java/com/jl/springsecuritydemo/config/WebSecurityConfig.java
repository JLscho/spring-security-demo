package com.jl.springsecuritydemo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity(debug = true)
public class WebSecurityConfig {

    @Bean
    public UserDetailsService loadInMemoryUserDetailsService(){
        UserDetails user1 = User.withUsername("user1").password("12345").roles("Admin").build();
        UserDetails user2 = User.withUsername("user2").password("hhhhh123").roles("User").build();
        return new InMemoryUserDetailsManager(List.of(user1, user2));
    }

    @Bean
    public PasswordEncoder loadNoPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
