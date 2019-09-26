package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Student;
import com.mac.demo.vo.QueryStudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

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
     * 学生登录  ---根据手机号查询学生信息
     * @param phone
     * @return
     */
    @Select("select * from student where student_phone = #{phone}")
    Student selectStudentByPhone(String phone);


    /**
     * 获取学生列表
     */
    @Select("select * from student limit #{page},#{limit}")
    Map<String, Object> getStudent(QueryStudentVo queryStudentVo);

    /**
     * 获取学生数量
     * @return
     */
    @Select("select count(1) from student")
    int getStudentCount();


    List<Student> getStudentByCondition(QueryStudentVo queryStudentVo);


    int getStudentByConditionCount(QueryStudentVo queryStudentVo);
}