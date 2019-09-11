package com.mac.demo.controller;

import com.mac.demo.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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

    @ApiOperation("教师首页")
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "admin/index";
    }

    @ApiOperation("教师登录页面")
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "admin/login";
    }

}
