package com.jl.springsecuritydemo.config;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
public class JwtUtilities{

    public String extractSub(String token) {
        return "sub";
    }


    public boolean validateToken(String token) {
        return !token.isBlank();
    }

    public String getToken (HttpServletRequest httpServletRequest) {
         final String bearerToken = httpServletRequest.getHeader("Authorization");
         if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
         {return bearerToken.substring(7); }
         return null;
    }

    public List<SimpleGrantedAuthority> extractRoles(String token) {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
