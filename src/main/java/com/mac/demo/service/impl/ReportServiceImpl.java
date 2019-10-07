package com.mac.demo.service.impl;

import com.mac.demo.config.RedisUtil;
import com.mac.demo.mapper.ReportMapper;
import com.mac.demo.service.ReportService;
import com.mac.demo.utils.PaperUtils;
import com.mac.demo.vo.QuerySelectQuestionVo;
import com.mac.demo.vo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname ReportServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:53 上午
 * @Created by wangxianlin
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportMapper reportMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Map<String, Object> getReport(ReportVo reportVo) {
        Map<String, Object> map = new HashMap<>();
        reportVo.setPage((reportVo.getPage()-1)*(reportVo.getLimit()));
        List<ReportVo> list = reportMapper.getReport(reportVo);
        map.put("data",list);
        int count = reportMapper.getReportCount();
        map.put("count",count);
        return map;
    }

    @Override
    public ReportVo getReportIndex(Integer studentId, Integer paperId) {
        //得到该门试卷的平均分数
        double avgScore = reportMapper.getAvgScoreByPaperId(paperId);
        ReportVo reportVo =reportMapper.getReportIndex(studentId,paperId);
        reportVo.setAvgScore(avgScore);
        //获取选择题 ---放入list集合中 ---我的答案
        reportVo.setSelectList(PaperUtils.String2List(reportVo.getAnswerSelect()));
        reportVo.setSelectQuestionList(PaperUtils.String2List(reportVo.getCorrectSelect()));
        reportVo.setAbilityList(PaperUtils.String2List(reportVo.getAbility()));
        reportVo.setKnowledgeList(PaperUtils.String2List(reportVo.getKnowledge()));
        return reportVo;
    }
}
