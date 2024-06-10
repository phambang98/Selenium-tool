package com.seleniumtool.core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "BATCH_STEP_EXECUTION")
public class BatchStepExecution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STEP_EXECUTION_ID")
    private Long stepExecutionId;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "STEP_NAME")
    private Long stepName;

    @Column(name = "JOB_EXECUTION_ID")
    private Integer jobExecutionId;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "START_TIME")
    private Date startTime;

    @Column(name = "END_TIME")
    private Date endTime;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "COMMIT_COUNT")
    private Integer commitCount;

    @Column(name = "READ_COUNT")
    private Integer readCount;

    @Column(name = "FILTER_COUNT")
    private Integer filterCount;

    @Column(name = "WRITE_COUNT")
    private Integer writeCount;

    @Column(name = "READ_SKIP_COUNT")
    private Integer readSkipCount;

    @Column(name = "WRITE_SKIP_COUNT")
    private Integer writeSkipCount;

    @Column(name = "PROCESS_SKIP_COUNT")
    private Integer processSkipCount;

    @Column(name = "ROLLBACK_COUNT")
    private Integer rollbackCount;

    @Column(name = "EXIT_CODE")
    private String exitCode;

    @Column(name = "EXIT_MESSAGE")
    private String exitMessage;

    @Column(name = "LAST_UPDATED")
    private String lastUpdated;

}
