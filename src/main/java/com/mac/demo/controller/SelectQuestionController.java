package com.mac.demo.controller;

import com.mac.demo.service.SelectQuestionService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Classname SelectQuestionController
 * @Description TODO
 * @Date 2019/9/12 1:01 上午
 * @Created by wangxianlin
 */
@Api(tags = "选择题接口")
@RequestMapping("selectquestion")
@Controller
public class SelectQuestionController {
    @Resource
    private SelectQuestionService selectQuestionService;
}
