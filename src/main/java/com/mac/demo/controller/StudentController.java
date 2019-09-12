package com.mac.demo.controller;

import com.mac.demo.model.Student;
import com.mac.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Classname StudentController
 * @Description TODO
 * @Date 2019/9/12 12:40 上午
 * @Created by wangxianlin
 */
@Api(tags = "学生接口")
@RequestMapping("student")
@Controller
public class StudentController {
    @Resource
    private StudentService studentService;

    @ApiOperation("学生登录页面")
    @GetMapping("/toIndex")
    public String toIndex(){
        return "student/index";
    }


    @ApiOperation("学生登录页面")
    @GetMapping("/toLogin")
    public String toLogin(){
        return "student/login";
    }

    @ApiOperation("学生成绩报告页面")
    @GetMapping("/toReport")
    public String toReport(){
        return "student/report";
    }

    @ApiOperation("学生注册页面")
    @GetMapping("/toRegister")
    public String toRegister(){
        return "student/register";
    }

    /**
     * 学生注册
     * @param record
     * @return
     */
    @ApiOperation("学生注册")
    @PostMapping("/insertStudent")
    public int insertSelective(@RequestBody Student record) {
        return studentService.insertSelective(record);
    }

    /**
     * 学生登录校验
     * @param phone
     * @param password
     * @param request
     * @return
     */
    @ApiOperation("学生注册")
    @PostMapping("/checkLogin")
    public String checkLogin(@RequestParam("phone") String phone, @RequestParam("password") String password,
            HttpServletRequest request) {
        if(studentService.checkLogin(phone).getStudentPassword().equals(password)){
            Student student = studentService.checkLogin(password);
            request.getSession().setAttribute("student",student);
            return "success";
        }else{
            return null;
        }
    }

    /**
     * 从session中获取学生对象
     * @param request
     * @param studentBean
     * @return
     */
    @ApiOperation(value = "获取学生的session对象")
    @PostMapping("/getStudentSession")
    public Student getStudentSession(HttpServletRequest request, @RequestParam("studentBean") String studentBean){
        Student student = (Student) request.getSession().getAttribute(studentBean);
        if (student == null) {
            return null;
        } else {
            return student;
        }
    }

    /**
     * 修改学生密码
     * @param passWord
     * @return
     */
    @ApiOperation(value = "修改学生密码")
    @PostMapping("/updateStudentPassword")
    public int changePassWord(@RequestParam("password") String passWord,HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute("student");
        return studentService.changePassWord(passWord,student.getStudentId());
    }

}
