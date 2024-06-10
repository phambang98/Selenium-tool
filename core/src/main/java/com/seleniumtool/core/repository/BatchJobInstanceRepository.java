package com.seleniumtool.core.repository;

import com.seleniumtool.core.entity.BatchJobInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchJobInstanceRepository extends JpaRepository<BatchJobInstance, Long> {
    boolean existsByJobName(String jobName);
}
