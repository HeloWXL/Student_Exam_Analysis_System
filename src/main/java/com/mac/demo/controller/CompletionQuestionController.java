package com.mac.demo.controller;

import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.service.CompletionQuestionService;
import com.mac.demo.utils.ExcelUtil;
import com.mac.demo.vo.QueryCompletionQuestionVo;
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
    public Map<String,Object> getCompletionQuestion(@RequestBody QueryCompletionQuestionVo queryCompletionQuestionVo){
        Map<String,Object> map = completionQuestionService.getCompletionQuestion(queryCompletionQuestionVo);
        map.put("msg","");
        map.put("code","0");
        return map;
    }

    @ApiOperation("添加填空题")
    @PostMapping("/insertCompletionQuestion")
    @ResponseBody
    public int insertSelective(@RequestBody CompletionQuestion completionQuestion){
        return completionQuestionService.insertSelective(completionQuestion);
    }

    @ApiOperation("修改填空题")
    @PostMapping("/updateCompletionQuestion")
    @ResponseBody
    public int updateCompletionQuestion(@RequestBody CompletionQuestion completionQuestion) {
        return completionQuestionService.updateByPrimaryKeySelective(completionQuestion);
    }

    @ApiOperation("删除填空题")
    @GetMapping("/deleteCompletionQuestion")
    @ResponseBody
    public int deleteCompletionQuestion(@RequestParam("completionId") Integer completionId) {
        return completionQuestionService.deleteByPrimaryKey(completionId);
    }

    @ApiOperation("批量导入填空题")
    @PostMapping("/uploadCompletionQuestion")
    @ResponseBody
    public  Map<String,Object>  importCompletionQuestion(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String pattern = fileName.substring(fileName.lastIndexOf(".") + 1);
        List<List<String>> listContent = new ArrayList<>();
        String message = "导入成功";

        try {
            if (file != null) {
                //文件类型判断
                if (!ExcelUtil.isEXCEL(file)) {
                    message="文件为空";
                }
                listContent = ExcelUtil.readExcelContents(file, pattern);
                //文件内容判断
                if (listContent.isEmpty()) {

                    message="表格内容为空";
                }
                completionQuestionService.importCompletionQuestion(listContent);
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

