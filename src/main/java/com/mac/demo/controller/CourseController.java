package com.mac.demo.controller;

import com.mac.demo.model.Course;
import com.mac.demo.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation("获取课程列表-分页")
    @GetMapping("/getCourse")
    @ResponseBody
    public Map<String, Object> getCourse(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        Map<String, Object> map = courseService.getCourse(page,limit);
        map.put("code","0");
        map.put("msg","");
        return map;
    }

    @ApiOperation("添加课程")
    @PostMapping("/insertCourse")
    @ResponseBody
    public int insertSelective(@RequestBody Course course) {
        return courseService.insertSelective(course);
    }

    @ApiOperation("修改课程")
    @PostMapping("/updateCourseById")
    @ResponseBody
    public int updateCourseById(@RequestBody Course course) {
        return courseService.updateByPrimaryKeySelective(course);
    }
}
