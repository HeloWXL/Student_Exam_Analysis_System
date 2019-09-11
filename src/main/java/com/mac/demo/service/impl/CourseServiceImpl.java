package com.mac.demo.service.impl;

import com.mac.demo.mapper.CourseMapper;
import com.mac.demo.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname CourseServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:50 上午
 * @Created by wangxianlin
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;
}
