package com.mac.demo.controller;

import com.mac.demo.service.TestService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2019/9/12 1:01 上午
 * @Created by wangxianlin
 */
@Api(tags = "考试接口")
@RequestMapping("test")
@Controller
public class TestController {
    @Resource
    private TestService testService;
}
