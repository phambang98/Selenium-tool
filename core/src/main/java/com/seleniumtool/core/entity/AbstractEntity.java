package com.seleniumtool.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;
@Data
@MappedSuperclass
public class AbstractEntity {

    @Column(name = "LAST_APPROVE_BY")
    protected String lastApproveBy;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "LAST_APPROVE_DATE")
    protected Date lastApproveDate;

    @Column(name = "LAST_UPDATE_BY")
    protected String lastUpdateBy;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "LAST_UPDATE_DATE")
    protected Date lastUpdateDate;

    @Column(name = "STATUS")
    protected String status;
}
