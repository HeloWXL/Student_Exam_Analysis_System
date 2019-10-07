package com.mac.demo.service;

import com.mac.demo.model.Course;

import java.util.List;
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

    /**
     * 根据ID删除课程
     * @param courseId
     * @return
     */
    int deleteByPrimaryKey(Integer courseId);

    /**
     * 获取课程列表
     * @param page
     * @param limit
     * @return
     */
    Map<String,Object> getCourse(Integer page, Integer limit);

    /**
     * 动态获取课程
     * @return
     */
    List<Course> getCourseList();
}
