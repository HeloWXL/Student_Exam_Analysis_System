package com.mac.demo.controller;

import com.mac.demo.service.ReportService;
import com.mac.demo.vo.QueryCompletionQuestionVo;
import com.mac.demo.vo.ReportVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Classname ReportController
 * @Description TODO
 * @Date 2019/9/12 1:00 上午
 * @Created by wangxianlin
 */
@Api(tags = "报告接口")
@RequestMapping("report")
@Controller
public class ReportController {
    @Resource
    private ReportService reportService;

    /**
     * @author  yechengchao
     * @param reportVo
     * @return
     */
    @ApiOperation("获取报告-分页")
    @PostMapping("/getReport")
    @ResponseBody
    public Map<String,Object> getReport(@RequestBody ReportVo reportVo){
        Map<String,Object> map = reportService.getReport(reportVo);
        map.put("msg","");
        map.put("code","0");
        return map;
    }

    /**
     * @author  yechengchao
     * @return
     */
    @ApiOperation("获取报告参数填充报告页面")
    @GetMapping("/getReportIndex")
    @ResponseBody
    public ReportVo getReportIndex(@RequestParam("studentId") Integer studentId,
                                   @RequestParam("paperId") Integer paperId ){
        return reportService.getReportIndex(studentId,paperId);
    }
}
