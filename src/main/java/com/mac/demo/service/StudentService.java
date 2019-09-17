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
    Student checkLogin(String phone);

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
}
