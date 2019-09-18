package com.mac.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Classname PaperTestAdminVo
 * @Description TODO
 * @Date 2019/9/15 1:35 上午
 * @Created by wangxianlin
 */
@Data
public class PaperTestAdminVo {
    private Integer paperId;

    private String testName;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer time;

    private String paperName;

    private String adminName;

    private Integer state;

}
