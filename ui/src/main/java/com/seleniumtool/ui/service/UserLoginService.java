package com.seleniumtool.ui.service;

import com.seleniumtool.core.entity.UserLogin;
import com.seleniumtool.core.enums.Provider;
import com.seleniumtool.core.model.UsersSignUpModel;
import com.seleniumtool.core.repository.UserLoginRepository;
import com.seleniumtool.ui.model.CustomOAuth2Users;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;

@Service
public class UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

//    public UserLogin authenticate(UsersSignUpModel usersSignUpModel, Model model){
//        String userName = usersSignUpModel.getUserName();
//        String email = usersSignUpModel.getEmail();
//        String password = usersSignUpModel.getPassword();
//        String confirmPassword = usersSignUpModel.getConfirmPassword();
//        if (!StringUtils.equals(password, confirmPassword)) {
//            model.addAttribute("errorPassword", "Password And Confirm Password does not match!");
//            return "login";
//        }
//        if (userLoginRepository.existsByUserName(userName)) {
//            model.addAttribute("errorUserName", "User name already exist!");
//            return "login";
//        }
//        UserLogin users = new UserLogin();
//        users.setEmail(email);
//        users.setUserName(userName);
//        users.setPassword(password);
//        users.setStatus("A");
//        users.setRoles(userName);
//        users = userLoginRepository.save(users);
//    }

    public void processOAuthPostLogin(CustomOAuth2Users customOAuth2Users) {
        String registrationId = customOAuth2Users.getRegistrationId();
        UserLogin existUserLogin = userLoginRepository.findByUserNameAndProviderEqualsIgnoreCase(customOAuth2Users.getName(), registrationId);
        //FIXME-TODO
        if (existUserLogin == null) {
            UserLogin users = new UserLogin();
            Map<String, Object> mapAttr = customOAuth2Users.getAttributes();
            users.setUserName((String) mapAttr.getOrDefault("sub", customOAuth2Users.getEmail()));
            users.setProvider(Provider.GOOGLE.name());
            users.setStatus("A");
            users.setEmail(customOAuth2Users.getEmail());
            userLoginRepository.save(users);

            System.out.println("Created new user: " + customOAuth2Users.getName());
        }

    }
}
