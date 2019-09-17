package com.mac.demo.controller;

import com.mac.demo.model.Test;
import com.mac.demo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2019/9/12 1:01 上午
 * @Created by wangxianlin
 */
@Api(tags = "考试接口")
@RequestMapping("test")
@Controller
public class TestController {
    @Resource
    private TestService testService;


    @ApiOperation("删除考试")
    @GetMapping("/deleteByTest")
    @ResponseBody
    public int deleteByTest(@RequestParam("testId") Integer testId) {
        return testService.deleteByTest(testId);
    }


    @ApiOperation("发布考试")
    @PostMapping("/insertTest")
    @ResponseBody
    public int insertTest(@RequestBody Test record) {
        return testService.insertTest(record);
    }


    @ApiOperation("修改考试")
    @PostMapping("/updateByTest")
    @ResponseBody
    public int updateByTest(@RequestBody Test record) {
        return testService.updateByTest(record);
    }


    @ApiOperation("获取考试列表-分页")
    @GetMapping("/getTest")
    @ResponseBody
    public Map<String, Object> getTest(Integer page, Integer limit) {
        Map<String, Object> map = testService.getTest(page,limit);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @ApiOperation("获取考试列表")
    @GetMapping("/getTestAdmin")
    @ResponseBody
    public List<Test> getTest(){
        return testService.getTest();
    }
}
