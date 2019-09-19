package com.mac.demo.controller;

import com.mac.demo.model.Admin;
import com.mac.demo.model.Student;
import com.mac.demo.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Classname AdminController
 * @Description TODO
 * @Date 2019/9/12 12:40 上午
 * @Created by wangxianlin
 */
@Api(tags = "管理员接口")
@RequestMapping("admin")
@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

    @ApiOperation("管理员首页")
    @GetMapping("/toIndex")
    public String toIndex(){
        return "admin/index";
    }

    /**
     * @author: yechengchao
     * @return
     */
    @ApiOperation("管理员退出登录页面")
    @PostMapping("/toLogout")
    public String toLogout(HttpServletRequest request){
        request.getSession().setAttribute("admin","");
        return "admin/login";
    }

    @ApiOperation("管理员登录页面")
    @GetMapping("/toLogin")
    public String toLogin(){
        return "admin/login";
    }

    @ApiOperation("学生管理页面")
    @GetMapping("/toStudent")
    public String toStudent(){
        return "admin/student";
    }

    @ApiOperation("选择题管理页面")
    @GetMapping("/toSelectQuestion")
    public String toSelectQuestion(){
        return "admin/selectQuestion";
    }


    @ApiOperation("填空题管理页面")
    @GetMapping("/toCompletionQuestion")
    public String toCompletionQuestion(){
        return "admin/completionQuestion";
    }


    @ApiOperation("题目类型管理页面")
    @GetMapping("/toType")
    public String toType(){
        return "admin/type";
    }

    @ApiOperation("试卷管理页面")
    @GetMapping("/toPaper")
    public String toPaper(){
        return "admin/paper";
    }

    @ApiOperation("考试管理页面")
    @GetMapping("/toTest")
    public String toTest(){
        return "admin/test";
    }

    @ApiOperation("课程管理页面")
    @GetMapping("/toCourse")
    public String toCourse(){
        return "admin/course";
    }

    @ApiOperation("系统配置")
    @GetMapping("/toSystem")
    public String toSystem(){
        return "admin/system";
    }

    /**
     * 修改管理员密码
     * @param passWord
     * @return
     */
    @ApiOperation("管理员修改密码")
    @PostMapping("/changePassWord")
    @ResponseBody
    public int changePassWord(@RequestParam("passWord") String passWord,HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
       request.getSession().setAttribute("msg","密码修改成功，请重新登录");
        return adminService.changePassWord(passWord,admin.getAdminId());
    }

    /**
     * 管理员登录
     * @param adminName
     * @return
     */
    @ApiOperation("管理员登录")
    @PostMapping("/checkLogin")
    public String checkLogin(@RequestParam("adminName") String adminName, @RequestParam("password") String password,
                            HttpServletRequest request) {
        String msg="";
        if(adminService.checkLogin(adminName).getAdminPassword().equals(password)){
            Admin admin = adminService.checkLogin(adminName);
            request.getSession().setAttribute("admin",admin);
            request.getSession().removeAttribute("msg");
            return "redirect:/admin/toIndex";
        }else{
            msg="密码错误";
            request.getSession().setAttribute("msg",msg);
            return "admin/login";
        }
    }

    /**
     * 从session中获取管理员对象
     * @param request
     * @param adminBean
     * @return
     */
    @ApiOperation(value = "获取管理员的session对象")
    @PostMapping("/getStudentSession")
    public Admin getStudentSession(HttpServletRequest request, @RequestParam("adminBean") String adminBean){
        Admin admin = (Admin) request.getSession().getAttribute(adminBean);
        if (admin == null) {
            return null;
        } else {
            return admin;
        }
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @ApiOperation("添加管理员")
    @PostMapping("/insertAdmin")
    @ResponseBody
    public int insertSelective(@RequestBody Admin admin) {
        return adminService.insertSelective(admin);
    }


}
