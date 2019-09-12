package com.mac.demo.service.impl;

import com.mac.demo.mapper.StudentMapper;
import com.mac.demo.model.Student;
import com.mac.demo.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname StudentServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:55 上午
 * @Created by wangxianlin
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student checkLogin(String phone) {
        return studentMapper.checkLogin(phone);
    }

    @Override
    public int changePassWord(String passWord, int studentId) {
        return studentMapper.changePassWord(passWord,studentId);
    }
}
