package com.mac.demo.controller;

import com.mac.demo.service.AdminService;
import io.swagger.annotations.Api;
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
}
