package com.seleniumtool.core.repository;

import com.seleniumtool.core.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long>, UserLoginRepositoryCustom {
    UserLogin findByUserName(String userName);

    UserLogin findByUserNameAndProviderEqualsIgnoreCase(String userName, String provider);

    boolean existsByUserName(String userName);
}
