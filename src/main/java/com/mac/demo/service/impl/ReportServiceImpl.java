package com.mac.demo.service.impl;

import com.mac.demo.config.RedisUtil;
import com.mac.demo.mapper.ReportMapper;
import com.mac.demo.mapper.StudentMapper;
import com.mac.demo.service.ReportService;
import com.mac.demo.utils.PaperUtils;
import com.mac.demo.vo.QuerySelectQuestionVo;
import com.mac.demo.vo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
    @Resource
    private StudentMapper studentMapper;
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
        //从数据库中获取到数据
        ReportVo reportVo =reportMapper.getReportIndex(studentId,paperId);




        //赋值操作
        reportVo.setAvgScore(avgScore);
        //获取选择题 ---放入list集合中 ---我的答案
        reportVo.setSelectList(PaperUtils.String2List(reportVo.getAnswerSelect()));
        reportVo.setSelectQuestionList(PaperUtils.String2List(reportVo.getCorrectSelect()));
        //能力列表
        reportVo.setAbilityList(PaperUtils.String2List(reportVo.getAbility()));

        List<String> abilityList = reportVo.getAbilityList();
        List<String> list = new ArrayList<>();

        for (String s:abilityList
             ) {
            list.add("'"+s+"'");
        }
        reportVo.setList(list);

        //存放能力类型 统计
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String item: abilityList){
            if(map.containsKey(item)){
                map.put(item, map.get(item).intValue() + 1);
            }else{
                map.put(item, new Integer(1));
            }
        }
        Iterator<String> keys = map.keySet().iterator();
        List<Object> listObject = new ArrayList<>();
        while(keys.hasNext()){
            String key = keys.next();
            listObject.add(key);
            listObject.add(map.get(key).intValue());
        }
        reportVo.setAbilityListMap(listObject);
        //知识点列表
        reportVo.setKnowledgeList(PaperUtils.String2List(reportVo.getKnowledge()));
        //学生姓名
        reportVo.setStudentName(studentMapper.getStudentNameById(studentId));
        return reportVo;
    }
}
