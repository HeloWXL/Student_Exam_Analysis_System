package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 根据ID删除学生
     * @param studentId
     * @return
     */
    int deleteByPrimaryKey(Integer studentId);

    /**
     * 添加学生
     * @param record
     * @return
     */
    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    /**
     * 根据ID修改学生
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * 学生登录
     * @param phone
     * @return
     */
    @Select("select * from student where student_phone = #{phone}")
    Student checkLogin(String phone);


    /**
     * 获取学生列表
     */
    @Select("select * from student limit #{page},#{limit}")
    List<Student> getStudent(Integer page,Integer limit);

    /**
     * 获取学生数量
     * @return
     */
    @Select("select count(1) from student")
    int getStudentCount();

}