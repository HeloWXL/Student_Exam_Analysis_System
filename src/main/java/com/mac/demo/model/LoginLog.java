package com.mac.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class LoginLog {

    private Integer loginLogId;

    private Integer sutdentId;

    private String ip;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;
}