package com.mac.demo.controller;

import com.mac.demo.model.Paper;
import com.mac.demo.model.Student;
import com.mac.demo.service.PaperService;
import com.mac.demo.service.StudentService;
import com.mac.demo.vo.PaperTestAdminVo;
import com.mac.demo.vo.QueryStudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

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
    @Resource
    private PaperService paperService;

    @ApiOperation("学生未登录首页页面")
    @GetMapping("/toNoIndex")
    public String toNoIndex(){
        return "student/no_index";
    }

    @ApiOperation("学生首页页面")
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

    @ApiOperation("学生")
    @GetMapping("/toRegister")
    public String toRegister(){
        return "student/register";
    }

    @ApiOperation("考试声明页面")
    @GetMapping("/toDeclaer/{paperId}")
    public String toDeclaer(@PathVariable("paperId") Integer paperId ,Model model){
        Paper p = paperService.selectByPrimaryKey(paperId);
        model.addAttribute("paper",p);
        return "student/declare";
    }

    @ApiOperation("考试页面")
    @GetMapping("/toTest")
    public String toTest(){
        return "student/test";
    }

    @ApiOperation("跳转到学生试卷列表页面")
    @GetMapping("/getPaperByList/{testId}")
    public String getPaperByList(@PathVariable("testId") Integer testId, Model model){
        List<PaperTestAdminVo> list =paperService.getPaperByTestId(testId);
        model.addAttribute("paperList",list);
        return "student/paperList";
    }

    /**
     * 学生注册
     * @param student
     * @return
     */
    @ApiOperation("学生注册")
    @PostMapping("/insertStudent")
    @ResponseBody
    public int insertSelective(@RequestBody Student student) {
        return studentService.insertSelective(student);
    }

    /**
     * 学生登录校验
     * @param phone
     * @param password
     * @param request
     * @return
     */
    @ApiOperation("学生登录")
    @PostMapping("/checkLogin")
    @ResponseBody
    public String checkLogin(@RequestParam("phone") String phone, @RequestParam("password") String password,
            HttpServletRequest request) {
        if(studentService.checkLogin(phone).getStudentPassword().equals(password)){
            Student student = studentService.checkLogin(password);
            request.getSession().setAttribute("student",student);
            return "1";
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
    @ResponseBody
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
    @ApiOperation(value = "学生修改密码")
    @PostMapping("/updateStudentPasswordByStudent")
    @ResponseBody
    public int updateStudentPasswordByStudent(@RequestParam("password") String passWord,HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute("student");
        student.setStudentPassword(passWord);
        return studentService.updateByPrimaryKeySelective(student);
    }

    @ApiOperation(value = "管理员修改学生密码")
    @PostMapping("/updateStudentPasswordByAdmin")
    @ResponseBody
    public int updateStudentPasswordByAdmin(@RequestBody Student student) {
        return studentService.updateByPrimaryKeySelective(student);
    }


    @ApiOperation(value = "获取学生列表")
    @PostMapping("/getStudent")
    @ResponseBody
    public Map<String, Object> getStudent(@RequestBody QueryStudentVo queryStudentVo){
        Map<String,Object> map = studentService.getStudent(queryStudentVo);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @ApiOperation(value = "删除学生")
    @GetMapping("/deleteStudent")
    @ResponseBody
    public int deleteStudent(@RequestParam("studentId")  Integer studentId) {
        return studentService.deleteByPrimaryKey(studentId);
    }


}
