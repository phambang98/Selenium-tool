package com.seleniumtool.core.repository;

import com.seleniumtool.core.entity.UserLogin;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserGameRepository extends JpaRepository<UserLogin, Long>, UserGameRepositoryCustom {
    UserLogin findByUserName(String userName);

    UserLogin findByUserNameAndProviderEqualsIgnoreCase(String userName, String provider);

    UserLogin findByEmail(String email);

    boolean existsByUserName(String userName);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<UserLogin> findByIdIsIn(List<Long> ids);

    Boolean existsByEmail(String email);

    List<UserLogin> findByUserNameIn(List<String> listUserName);

//    @Cacheable(value = "users", key = "T(java.lang.String).format('%s', #p0)")
//    List<Users> findByEmailIn(List<String> listEmail);

    @Query(value = "select * from Users for update nowait ",nativeQuery = true)
    List<UserLogin> findByEmailIn(List<String> listEmail);
}
