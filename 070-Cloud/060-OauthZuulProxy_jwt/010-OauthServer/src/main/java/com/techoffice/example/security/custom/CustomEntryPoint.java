package com.techoffice.example.security.custom;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public CustomEntryPoint(String loginUrl) {
        super(loginUrl);
    }

    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        String loginUrl = super.determineUrlToUseForThisRequest(request, response, authException);
        return loginUrl;
    }
}