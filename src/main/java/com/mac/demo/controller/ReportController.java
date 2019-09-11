package com.mac.demo.controller;

import com.mac.demo.service.ReportService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Classname ReportController
 * @Description TODO
 * @Date 2019/9/12 1:00 上午
 * @Created by wangxianlin
 */
@Api(tags = "报告接口")
@RequestMapping("report")
@Controller
public class ReportController {
    @Resource
    private ReportService reportService;
}
