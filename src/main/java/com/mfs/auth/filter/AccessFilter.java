package com.mfs.auth.filter;

import com.mfs.auth.configuration.TokenConfiguration;
import com.mfs.auth.facade.access.AccessFacade;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Component
public class AccessFilter extends OncePerRequestFilter {
    @Autowired
    private TokenConfiguration tokenConfiguration;
    @Autowired
    private AccessFacade accessFacade;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        Claims claims = null;
        if (StringUtils.isNotBlank(authHeader) && authHeader.startsWith("Bearer ")) {
            claims = tokenConfiguration.decryptToken(authHeader.substring(7));
        }

        if (Objects.nonNull(claims) && StringUtils.isNotBlank(claims.getSubject()) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
            UserDetails userDetails = accessFacade.loadUserByUsername(claims.getSubject());
            if (new Date().before(claims.getExpiration())) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
