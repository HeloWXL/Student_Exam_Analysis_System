package com.mac.demo.service;

import com.mac.demo.model.Student;

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
     * 学生登录
     * @param phone
     * @return
     */
    Student checkLogin(String phone);

    /**
     * 修改学生密码
     * @param passWord
     * @param studentId
     * @return
     */
    int changePassWord(String passWord ,int studentId);
}
