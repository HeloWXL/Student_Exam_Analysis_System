package com.mac.demo.controller;

import com.mac.demo.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Classname LoginLogController
 * @Description TODO
 * @Date 2019/10/13 2:33 下午
 * @Created by wangxianlin
 */
@Api(tags = "登录日志接口")
@RequestMapping("loginLogApi")
@Controller
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;


    @ApiOperation("跳转到登录日志页面")
    @GetMapping("/toLog")
    public String toTest(){
        return "admin/log";
    }


    @ApiOperation("登录日志")
    @GetMapping("/getLoginLog")
    @ResponseBody
    public Map<String, Object> getLoginLog(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        return loginLogService.getLoginLog(page,limit);
    }

}
