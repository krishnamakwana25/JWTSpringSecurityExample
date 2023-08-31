package com.jwt.example.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**
     * this method throw exception whenever unauthorized person try to logged in
     *     Method of this class is called whenever as exception is thrown due to
     *     unauthenticated user trying to access the resource that required authentication
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Access Denied..!!"+authException.getMessage());
        log.error("Access Denied..!!"+authException.getMessage());
    }
}
