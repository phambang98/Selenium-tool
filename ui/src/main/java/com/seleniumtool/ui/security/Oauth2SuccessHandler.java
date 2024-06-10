package com.seleniumtool.ui.security;

import com.seleniumtool.ui.model.CustomOAuth2Users;
import com.seleniumtool.ui.service.UserLoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Oauth2SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserLoginService userLoginService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomOAuth2Users oauthUser = (CustomOAuth2Users) authentication.getPrincipal();
        userLoginService.processOAuthPostLogin(oauthUser);
        response.sendRedirect("/home");
    }

}
