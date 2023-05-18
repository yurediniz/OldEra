package br.com.IgorAssis.OldEra.OldEra.filter;

import br.com.IgorAssis.OldEra.OldEra.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;

public class FilterToken {
    @Component
    @Transactional
    public class FilterToken  extends OncePerRequestFilter {

        @Autowired
        TokenService tokenService;

        @Autowired
        UserDetailsServiceImpl userDetailsService;

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain filterChain) throws ServletException, IOException {

            String token;

            var authorizationHeader = request.getHeader("Authorization");

            if(authorizationHeader != null){
                token = authorizationHeader.replace("Bearer ", "");
                var subject = this.tokenService.getSubject(token);

                var usuario = this.userDetailsService.loadUserByUsername(subject);

                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);

        }

    }
}
