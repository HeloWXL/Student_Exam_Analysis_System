package com.mac.demo.controller;

import com.mac.demo.model.Type;
import com.mac.demo.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 添加题目类型
     * @param record
     * @return
     */
    @ApiOperation("添加题目类型")
    @PostMapping("/insertType")
    @ResponseBody
    public int insertType(@RequestBody Type record) {
        return typeService.insertSelective(record);
    }

    /**
     * 获取题目类型列表
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation("获取题目类型列表-分页")
    @GetMapping("/getType")
    @ResponseBody
    public Map<String, Object> getType(@RequestParam("page") Integer page,
                                       @RequestParam("limit") Integer limit) {
        Map<String, Object> map = typeService.getType(page,limit);
        map.put("msg","");
        map.put("code",0);
        return map;
    }

    /**
     * 根据ID删除题目类型
     * @param typeId
     * @return
     */
    @ApiOperation("根据ID删除题目类型")
    @GetMapping("/deleteType")
    @ResponseBody
    public int deleteType(@RequestParam("typeId") Integer typeId) {
        return typeService.deleteByPrimaryKey(typeId);
    }

    /**
     * 根据ID修改题目类型
     * @param record
     * @return
     */
    @ApiOperation("根据ID删除题目类型")
    @PostMapping("/updateBType")
    @ResponseBody
    public int updateBType(@RequestBody Type record) {
        return typeService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation("加载能力类型列表")
    @GetMapping("/getTypeList")
    @ResponseBody
    public List<Type> getTypeList(){
        return  typeService.getTypeList();
    }
}
