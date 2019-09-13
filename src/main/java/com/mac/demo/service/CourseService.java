package com.mac.demo.service;

import com.mac.demo.model.Course;

import java.util.Map;

/**
 * @Classname CourseService
 * @Description TODO
 * @Date 2019/9/12 12:42 上午
 * @Created by wangxianlin
 */
public interface CourseService {

    /**
     * 添加课程
     * @param record
     * @return
     */
    int insertSelective(Course record);

    /**
     * 根据ID修改课程
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Course record);


    Map<String,Object> getCourse(Integer page, Integer limit);
}
