package com.mac.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Classname TestAdminVo
 * @Description TODO
 * @Date 2019/9/15 12:01 上午
 * @Created by wangxianlin
 */
@Data
public class TestAdminVo {
    private Integer testId;

    private String testName;

    private Integer time;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String adminName;

}
