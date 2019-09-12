package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    int deleteByPrimaryKey(Integer studentId);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**
     * 学生登录
     * @param phone
     * @return
     */
    @Select("select * from student where student_phone = #{phone}")
    Student checkLogin(String phone);

    /**
     * 修改学生密码
     * @param passWord
     * @param studentId
     * @return
     */
    @Update("update student set student_password=#{password} where student_id = #{studentId}")
    int changePassWord(String passWord ,int studentId);

    /**
     * 获取学生列表---xml
     */

}