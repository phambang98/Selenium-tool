package com.seleniumtool.core.repository.impl;

import com.seleniumtool.core.repository.UserGameRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class UserGameRepositoryCustomImpl implements UserGameRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

}
