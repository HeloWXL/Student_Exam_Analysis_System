package com.mac.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 管理员实体类
 */
@Data
public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminPassword;

    private Date createTime;
}