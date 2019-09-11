package com.mac.demo.controller;

import com.mac.demo.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Classname CourseController
 * @Description TODO
 * @Date 2019/9/12 1:00 上午
 * @Created by wangxianlin
 */
@Api(tags = "课程接口")
@RequestMapping("course")
@Controller
public class CourseController {
    @Resource
    private CourseService courseService;
}
