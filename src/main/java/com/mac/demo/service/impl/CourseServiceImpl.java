package com.mac.demo.service.impl;

import com.mac.demo.mapper.CourseMapper;
import com.mac.demo.model.Course;
import com.mac.demo.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 添加课程
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    /**
     * 根据ID修改课程
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据ID删除课程
     * @param courseId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer courseId) {
        return courseMapper.deleteByPrimaryKey(courseId);
    }

    /**
     * 获取课程列表
     * @param page
     * @param limit
     * @return
     */
    @Override
    public Map<String, Object> getCourse(Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        List<Course> list = courseMapper.getCourse((page-1)*limit,limit);
        map.put("data",list);
        int count = courseMapper.getCourseCount();
        map.put("count",count);
        return map;
    }
}
