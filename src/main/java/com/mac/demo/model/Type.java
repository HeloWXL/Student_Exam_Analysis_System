package com.mac.demo.model;

import lombok.Data;

import java.util.Date;
@Data
public class Type {
    private Integer typeId;

    private String typeName;

    private Date createTime;
}