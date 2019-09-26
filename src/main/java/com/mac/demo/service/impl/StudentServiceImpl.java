package com.mac.demo.service.impl;

import com.mac.demo.mapper.StudentMapper;
import com.mac.demo.model.Student;
import com.mac.demo.service.StudentService;
import com.mac.demo.utils.Md5Utils;
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
        //设置注册密码为md5加密 + 加盐
        record.setStudentPassword(Md5Utils.getSaltMD5(record.getStudentPassword()));
        return studentMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer studentId) {
        return studentMapper.deleteByPrimaryKey(studentId);
    }

    @Override
    public Student selectStudentByPhone(String phone) {
        return studentMapper.selectStudentByPhone(phone);
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

    /**
     * 批量导入 暂时先放在这个
     * @param list
     */
    public void importStudentList(List<List<String>> list){
        for ( int i = 0 ; i <list.size();i++){
            Student student = new Student();

            String sno = list.get(i).get(0);
            int snolength = sno.length();

//            if(sno.substring(snolength-2,snolength).equals(".0")){
//                System.out.println(sno.substring(0,snolength-2));
//                student.setStudentNo(sno.substring(0,snolength-2));
//            }else{
//                student.setStudentNo(sno);
//            }
//            student.setStudentName(list.get(i).get(1));
////            密码默认为学号
//            student.setStudentPassword("123456");
//            student.setStudentClass(list.get(i).get(2));
//            student.setStudentApartment(list.get(i).get(3));
//            student.setSutdnetSex(list.get(i).get(4));
//            student.setStudentProfession(list.get(i).get(5));
//            String age = list.get(i).get(6);
//
//            int length = age.length();
//            if(age.substring(length-2, length).equals(".0")){
//                student.setStudentAge(Integer.parseInt(age.substring(0,length-2)));
//            }else{
//                student.setStudentAge(Integer.parseInt(age));
//            }
            studentMapper.insert(student);
        }
    }
}
