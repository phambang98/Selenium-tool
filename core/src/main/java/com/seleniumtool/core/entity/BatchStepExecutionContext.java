package com.seleniumtool.core.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "BATCH_STEP_EXECUTION_CONTEXT")
public class BatchStepExecutionContext {
    @Id
    @Column(name = "STEP_EXECUTION_ID")
    private Long stepExecutionId;

    @Column(name = "SHORT_CONTEXT")
    private String shortContext;
    @Column(name = "SERIALIZED_CONTEXT")
    private String serializedContext;
}
