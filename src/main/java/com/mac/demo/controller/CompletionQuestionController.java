package com.mac.demo.controller;

import com.mac.demo.service.CompletionQuestionService;
import com.mac.demo.vo.CompletionCourseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;


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
    private CompletionQuestionService completionQuestionService;

    @ApiOperation("获取填空题列表-分页")
    @PostMapping("/getCompletionQuestion")
    @ResponseBody
    public Map<String,Object> getCompletionQuestion(Integer page, Integer limit){
        Map<String,Object> map = completionQuestionService.getCompletionQuestion(page,limit);
        map.put("msg","");
        map.put("code","0");
        return map;
    }
}
