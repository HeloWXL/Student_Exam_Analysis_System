package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    int deleteByPrimaryKey(Integer courseId);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    @Select("select * from course limit #{page},#{limit}")
    List<Course> getCourse(int page,int limit);

    @Select("select count(1) from course ")
    int getCourseCount();
}