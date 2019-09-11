package com.mac.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.concurrent.CompletionService;

/**
 * @Classname CompletionQuestionController
 * @Description TODO
 * @Date 2019/9/12 12:59 上午
 * @Created by wangxianlin
 */
@Api(tags = "填空题接口")
@RequestMapping("completionquestion")
@Controller
public class CompletionQuestionController {
    @Resource
    private CompletionService completionService;
}
