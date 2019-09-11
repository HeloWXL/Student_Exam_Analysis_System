package com.mac.demo.controller;

import com.mac.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Classname StudentController
 * @Description TODO
 * @Date 2019/9/12 12:40 上午
 * @Created by wangxianlin
 */
@Api(tags = "学生接口")
@RequestMapping("student")
@Controller
public class StudentController {
    @Resource
    private StudentService studentService;

    @ApiOperation("学生登录页面")
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "student/index";
    }


    @ApiOperation("学生登录页面")
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "student/login";
    }

    @ApiOperation("学生成绩报告页面")
    @RequestMapping("/toReport")
    public String toReport(){
        return "student/report";
    }

    @ApiOperation("学生注册页面")
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "student/register";
    }
}
