package com.seleniumtool.ui.security;

import com.seleniumtool.core.entity.UserLogin;
import com.seleniumtool.core.enums.Keys;
import com.seleniumtool.core.repository.UserLoginRepository;
import com.seleniumtool.ui.error.IncorrectPasswordException;
import com.seleniumtool.ui.error.IncorrectUserNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsersAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserLoginRepository userLoginRepository;


    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        final UserLogin userLogin = userLoginRepository.findByUserName(username);
        if (userLogin == null) {
            throw new IncorrectUserNameException(Keys.USER_NAME_NOT_FOUND.getDescription());
        }
        UserDetails userDetails = new UsersSecurity(userLogin);
        boolean checkPassword = passwordEncoder.matches(password, userDetails.getPassword());
        if (!checkPassword) {
            throw new IncorrectPasswordException(Keys.INCORRECT_PASSWORD.getDescription());
        }
        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType
                .equals(UsernamePasswordAuthenticationToken.class);
    }
}