package com.mac.demo.controller;

import com.mac.demo.service.TypeService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Classname TypeController
 * @Description TODO
 * @Date 2019/9/12 1:01 上午
 * @Created by wangxianlin
 */
@Api(tags = "题目类型接口")
@RequestMapping("type")
@Controller
public class TypeController {
    @Resource
    private TypeService typeService;

}
