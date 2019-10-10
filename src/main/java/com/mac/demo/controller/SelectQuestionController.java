package com.mac.demo.controller;

import com.mac.demo.model.SelectQuestion;
import com.mac.demo.service.SelectQuestionService;
import com.mac.demo.utils.ExcelUtil;
import com.mac.demo.utils.ExcelUtilSelectQuestion;
import com.mac.demo.vo.QuerySelectQuestionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation("获取选择题列表-分页")
    @PostMapping("/getSelectQuestion")
    @ResponseBody
    public Map<String,Object> getSelectQuestion(@RequestBody QuerySelectQuestionVo querySelectQuestionVo){
        Map<String,Object> map = selectQuestionService.getSelectQuestion(querySelectQuestionVo);
        map.put("msg","");
        map.put("code","0");
        return map;
    }

    @ApiOperation("添加选择题")
    @PostMapping("/insertSelectQuestion")
    @ResponseBody
    public int insertSelective(@RequestBody SelectQuestion selectQuestion){
        return selectQuestionService.insertSelective(selectQuestion);
    }

    @ApiOperation("修改选择题")
    @PostMapping("/updateSelectQuestion")
    @ResponseBody
    public int updateSelectQuestion(@RequestBody SelectQuestion selectQuestion) {
        return selectQuestionService.updateByPrimaryKeySelective(selectQuestion);
    }

    @ApiOperation("删除选择题")
    @GetMapping("/deleteSelectQuestion")
    @ResponseBody
    public int deleteSelectQuestion(@RequestParam("selectId") Integer selectId) {
        return selectQuestionService.deleteByPrimaryKey(selectId);
    }

    @ApiOperation("批量导入选择题")
    @PostMapping("/uploadSelect")
    @ResponseBody
    public Map<String,Object>  importSelect(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String pattern = fileName.substring(fileName.lastIndexOf(".") + 1);
        List<List<String>> listContent = new ArrayList<>();
        String message = "导入成功";

        try {
            if (file != null) {
                //文件类型判断
                if (!ExcelUtilSelectQuestion.isEXCEL(file)) {
                    message="文件为空";
                }
                listContent = ExcelUtilSelectQuestion.readExcelContents(file, pattern);
                //文件内容判断
                if (listContent.isEmpty()) {

                    message="表格内容为空";
                }
                selectQuestionService.importSelect(listContent);
            } else {

                message="未选择文件";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",message);
        map.put("data",fileName);
        return map;
    }

}
