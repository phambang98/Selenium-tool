package com.seleniumtool.core.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "BATCH_JOB_INSTANCE")
public class BatchJobInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_INSTANCE_ID")
    private Long jobInstanceId;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_key")
    private String jobKey;

}
