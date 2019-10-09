package com.mac.demo.controller;

import com.mac.demo.model.Admin;
import com.mac.demo.model.Paper;
import com.mac.demo.service.PaperService;
import com.mac.demo.vo.PaperTestAdminVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation("删除试卷")
    @GetMapping("/deletePaper")
    @ResponseBody
    public int deletePaper(@RequestParam("paperId") Integer paperId) {
        return paperService.deleteByPrimaryKey(paperId);
    }

    @ApiOperation("添加试卷")
    @PostMapping("/insertPaper")
    @ResponseBody
    public int insertPaper(Paper record) {
        return paperService.insertSelective(record);
    }

    @ApiOperation("修改试卷")
    @PostMapping("/updatePaper")
    @ResponseBody
    public int updatePaper(Paper record) {
        return paperService.updateByPrimaryKeySelective(record);
    }


    @ApiOperation("获取试卷列表-分页")
    @PostMapping("/getPaper")
    @ResponseBody
    public Map<String, Object> getPaper(@RequestBody PaperTestAdminVo paperTestAdminVo) {
        Map<String, Object> map = paperService.getPaper(paperTestAdminVo);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @ApiOperation("随机组卷")
    @GetMapping("/getPaperByAuto")
    @ResponseBody
    public Integer getPaperByAuto(@RequestParam("selectNum") Integer selectNum,
                                        @RequestParam("completionNum") Integer completionNum,
                                         @RequestParam("paperName") String paperName,
                                        @RequestParam("testId") Integer testId,
                                         @RequestParam("selectScore") Integer selectScore,
                                        @RequestParam("completionScore") Integer completionScore,
                                      HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Paper paper =new Paper();
        //添加管理员ID
        paper.setAdminId(admin.getAdminId());
        //试卷名称
        paper.setPaperName(paperName);
        //考试id
        paper.setTestId(testId);
        //分数
        paper.setSelectScore(selectScore);
        paper.setCompletionScore(completionScore);
        return  paperService.getPaperByAuto(paper,selectNum,completionNum);
    }

    @ApiOperation("试卷详细信息")
    @GetMapping("/selectPaperInfo/{paperId}")
//    @ResponseBody
    public String selectPaper(@PathVariable("paperId") Integer paperId,Model model){
        Paper p = paperService.selectPaper(paperId);
        model.addAttribute("paper",p);
        return "/student/test";
    }

    /**
     * @authod:叶程超
     * 启用试卷
     * @param paperId
     * @return
     */
    @ApiOperation("试卷状态修改-设置启用状态")
    @GetMapping("/setPaperStateOpen")
    @ResponseBody
    public Integer setPaperStateOpen(@RequestParam("paperId") Integer paperId){
        return paperService.setPaperStateOpen(paperId);
    }

    /**
     * @authod:叶程超
     * 启用试卷
     * @param paperId
     * @return
     */
    @ApiOperation("试卷状态修改-设置关闭状态")
    @GetMapping("/setPaperStateClose")
    @ResponseBody
    public Integer setPaperStateClose(@RequestParam("paperId") Integer paperId){
        return paperService.setPaperStateClose(paperId);
    }
}
