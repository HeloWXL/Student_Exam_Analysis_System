package com.mac.demo.service;

import com.mac.demo.model.Student;
import com.mac.demo.vo.QueryStudentVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Classname Studentservice
 * @Description TODO
 * @Date 2019/9/12 12:41 上午
 * @Created by wangxianlin
 */
public interface StudentService {
    /**
     * 学生注册
     * @param record
     * @return
     */
    int insertSelective(Student record);

    /**
     * 根据ID删除学生
     * @param studentId
     * @return
     */
    int deleteByPrimaryKey(Integer studentId);

    /**
     * 学生登录
     * @param phone
     * @return
     */
    Student selectStudentByPhone(String phone);

    /**
     * 根据ID修改学生
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * 获取学生列表
     */
    Map<String,Object> getStudent(QueryStudentVo queryStudentVo);

    Map<String, Object> getStudentByCondition(QueryStudentVo queryStudentVo);

    /***
     * @Author wangxl
     * @Description //获取近期注册学生人数
     * @Date 12:53 上午 2019/10/15
     * @Param []
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String, Object> getRigisteeStudentCount();

}
