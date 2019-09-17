package com.mac.demo.service.impl;

import com.mac.demo.mapper.StudentMapper;
import com.mac.demo.model.Student;
import com.mac.demo.service.StudentService;
import com.mac.demo.vo.QueryStudentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int deleteByPrimaryKey(Integer studentId) {
        return studentMapper.deleteByPrimaryKey(studentId);
    }

    @Override
    public Student checkLogin(String phone) {
        return studentMapper.checkLogin(phone);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Map<String, Object> getStudent(QueryStudentVo queryStudentVo) {
        Map<String, Object> map = new HashMap<>();
        queryStudentVo.setPage((queryStudentVo.getPage()-1)*queryStudentVo.getLimit());
        List<Student> list = studentMapper.getStudentByCondition(queryStudentVo);
        map.put("data",list);
        int count = studentMapper.getStudentByConditionCount(queryStudentVo);
        map.put("count",count);
        return map;
    }

    @Override
    public Map<String, Object> getStudentByCondition(QueryStudentVo queryStudentVo) {
        Map<String, Object> map = new HashMap<>();
        List<Student> list = studentMapper.getStudentByCondition(queryStudentVo);
        map.put("data",list);
        int count = studentMapper.getStudentByConditionCount(queryStudentVo);
        map.put("count",count);
        return map;
    }
}
