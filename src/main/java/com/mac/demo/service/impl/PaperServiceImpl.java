package com.mac.demo.service.impl;

import com.mac.demo.mapper.CompletionQuestionMapper;
import com.mac.demo.mapper.PaperMapper;
import com.mac.demo.mapper.SelectQuestionMapper;
import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.model.Paper;
import com.mac.demo.model.SelectQuestion;
import com.mac.demo.service.PaperService;
import com.mac.demo.utils.PaperUtils;
import com.mac.demo.vo.PaperTestAdminVo;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname PaperServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:53 上午
 * @Created by wangxianlin
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Resource
    private PaperMapper paperMapper;

    @Resource
    private SelectQuestionMapper selectQuestionMapper;

    @Resource
    private CompletionQuestionMapper completionQuestionMapper;

    @Override
    public int deleteByPrimaryKey(Integer paperId) {
        return paperMapper.deleteByPrimaryKey(paperId);
    }

    @Override
    public int insertSelective(Paper record) {
        return paperMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Paper record) {
        return paperMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Paper selectByPrimaryKey(Integer paperId) {
        return paperMapper.selectById(paperId);
    }

    @Override
    public Map<String, Object> getPaper(PaperTestAdminVo paperTestAdminVo) {
        Map<String, Object> map = new HashMap<>();
        paperTestAdminVo.setPage((paperTestAdminVo.getPage()-1)*(paperTestAdminVo.getLimit()));
        List<PaperTestAdminVo>  list = paperMapper.getPaper(paperTestAdminVo);
        map.put("data",list);
        int count = paperMapper.getPaperCount();
        map.put("count",count);
        return map;
    }

    @Override
    public List<PaperTestAdminVo> getPaperByTestId(Integer testId) {
        return paperMapper.getPaperByTestId(testId);
    }



    /**
     * 从题库中id集合抽取随机id集合
     * @param oldids
     * @param number
     * @return
     */
    public String getIds(List<Integer> oldids,int number){
        return PaperUtils.autoQustionId(oldids,number);
    }


    @Override
    public Integer getPaperByAuto(Paper paper ,Integer selectNum, Integer completionNum,Integer courseId) {
        int sNum = selectQuestionMapper.getSelectCountByCourseId(courseId);
        int cNum = completionQuestionMapper.getCompletionoCountBycourseId(courseId);
        //比较选择题数量和填空题数量 ----
        if(sNum<selectNum&&cNum<completionNum){
            return -1;
        }
        //该map用于存放随机的各类型题号
        Map<Object,Object> map=new HashMap();
        //存放选择题 ID
        StringBuilder selectString = new StringBuilder();
        //存放填空题ID
        StringBuilder completionString = new StringBuilder();
        //获取随机选择题id的集合
        List<Integer> sqids=new ArrayList<>();
        //随机选择填空题
        for(SelectQuestion selectQuestion:selectQuestionMapper.getSelectByCourseId(courseId)){
            //获取选择题的ID
            sqids.add(selectQuestion.getSelectId());
        }
        selectString.append(getIds(sqids,selectNum));
        List<Integer> cqids=new ArrayList<>();
        //随机选择填空题
        for(CompletionQuestion completionQuestion:completionQuestionMapper.getComppletionBycourseId(courseId)){
            //获取填空题的ID
            cqids.add(completionQuestion.getTypeId());
        }
        completionString.append(getIds(cqids,completionNum));
        map.put("sds",selectString.substring(0,selectString.length()-1));
        map.put("cds",completionString.substring(0,completionString.length()-1));
        System.out.println(map);
        //添加到数据库中
        paper.setCompletionList(completionString.toString());
        paper.setSelectList(selectString.toString());
        Integer i = paperMapper.insertSelective(paper);
        return i;
    }

    @Override
    public Paper selectPaper(Integer paperId) {
        //根据试卷的ID查询试卷的相信信息
        Paper p = paperMapper.selectByPrimaryKey(paperId);
        //遍历试卷中存放的选择题ID并根据ID查询选择题的详细信息存放在list中
        List<SelectQuestion> selectQuestionList = selectQuestionMapper.selectBatchIds(PaperUtils.getQuestionIds(p.getSelectList()));
        //遍历试卷中存放的填空题ID并根据ID查询填空题的详细信息存放在list中
        List<CompletionQuestion> completionQuestionList = completionQuestionMapper.selectBatchIds(PaperUtils.getQuestionIds(p.getCompletionList()));
        p.setSelectQuestionList(selectQuestionList);
        p.setCompletionQuestionList(completionQuestionList);
        return p;
    }

    /**
     * 启用试卷
     * @param paperId
     * @return
     */
    @Override
    public Integer setPaperStateOpen(Integer paperId) {
        return paperMapper.setPaperStateOpen(paperId);
    }

    /**
     * 关闭试卷
     * @param paperId
     * @return
     */
    @Override
    public Integer setPaperStateClose(Integer paperId) {
        return paperMapper.setPaperStateClose(paperId);
    }
}
