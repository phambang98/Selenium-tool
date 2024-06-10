package com.seleniumtool.core.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "BATCH_JOB_EXECUTION_PARAMS")
public class BatchJobExecutionParams {
    @Id
    @Column(name = "JOB_EXECUTION_ID")
    private Long jobExecutionId;

    @Column(name = "PARAMETER_NAME")
    private String parameterName;

    @Column(name = "PARAMETER_TYPE")
    private String parameterType;

    @Column(name = "PARAMETER_VALUE")
    private String parameterValue;

    @Column(name = "IDENTIFYING")
    private String identifying;

}
