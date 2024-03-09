package com.jl.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.List;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/custom/**").authenticated()
                                .requestMatchers("/default/**").permitAll()
                )
                //inject default BasicAuthenticationFilter
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .addFilterBefore(new LogCaptureFilter(), BasicAuthenticationFilter.class)
                .build();
    }

    @Bean
    public UserDetailsService loadMyInMemoryUserDetailsService() {
        UserDetails user1 = User.builder().username("testUser1").password("12345").build();
        UserDetails user2 = User.builder().username("testUser2").password("test12345").build();
        return new InMemoryUserDetailsManager(List.of(user1, user2));
    }

    @Bean
    public PasswordEncoder loadPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
