package com.mac.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 题目类型实体类
 */
@Data
public class Type {
    private Integer typeId;

    private String typeName;

    private Integer level;

    private Date createTime;

}