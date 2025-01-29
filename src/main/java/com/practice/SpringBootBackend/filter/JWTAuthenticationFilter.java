package com.practice.SpringBootBackend.filter;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.practice.SpringBootBackend.model.JWTDataHolder;
import com.practice.SpringBootBackend.service.JWTService;
import com.practice.SpringBootBackend.service.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter{

    private final JWTService jwtService;
    private final MyUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authenticationHeader = request.getHeader("Authorization");

        if(authenticationHeader == null || !authenticationHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        String jwtToken = authenticationHeader.substring(7);
        JWTDataHolder jwtDataHolder = jwtService.generateJwtDataHolder(jwtToken);

        String username = jwtDataHolder.extractUsername();
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if(jwtService.validateJWT(userDetails, jwtDataHolder)){
                UsernamePasswordAuthenticationToken upaToken 
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                upaToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    
                SecurityContextHolder.getContext().setAuthentication(upaToken);
            }
        }
            
        filterChain.doFilter(request, response);
    }
    
}
