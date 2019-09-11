package com.mac.demo.controller;

import com.mac.demo.service.PaperService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Classname PaperController
 * @Description TODO
 * @Date 2019/9/12 1:00 上午
 * @Created by wangxianlin
 */
@Api(tags = "试卷接口")
@RequestMapping("paper")
@Controller
public class PaperController {

    @Resource
    private PaperService paperService;

}
