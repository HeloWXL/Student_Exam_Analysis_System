package com.mac.demo.controller;

import com.mac.demo.service.AnswerService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Classname AnswerController
 * @Description TODO
 * @Date 2019/9/12 12:59 上午
 * @Created by wangxianlin
 */
@Api(tags = "提交答案接口")
@RequestMapping("answer")
@Controller
public class AnswerController {
    @Resource
    private AnswerService answerService;
}
