package com.jl.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/custom/**").authenticated()
                                .requestMatchers("/default/**").permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(new LogCaptureFilter(), BasicAuthenticationFilter.class)
                .build();
    }
}
