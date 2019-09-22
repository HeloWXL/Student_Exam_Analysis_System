package com.mac.demo.service.impl;

import com.mac.demo.mapper.AnswerMapper;
import com.mac.demo.mapper.CompletionQuestionMapper;
import com.mac.demo.mapper.PaperMapper;
import com.mac.demo.mapper.SelectQuestionMapper;
import com.mac.demo.model.Answer;
import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.model.Paper;
import com.mac.demo.model.SelectQuestion;
import com.mac.demo.service.AnswerService;
import com.mac.demo.utils.PaperUtils;
import com.mac.demo.vo.AnswerStudentPaperVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname AnswerServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:47 上午
 * @Created by wangxianlin
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private AnswerMapper answerMapper;

    @Resource
    private PaperMapper paperMapper;

    @Resource
    private SelectQuestionMapper selectQuestionMapper;

    @Resource
    private CompletionQuestionMapper completionQuestionMapper;

    @Override
    public Map<String,Object> getAnswerStudentPaperVo(Integer page, Integer limit) {
        List<AnswerStudentPaperVo> list = answerMapper.getAnswerStudentPaperVo((page-1)*limit,limit);
        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        int count = answerMapper.getAnswerCount();
        map.put("count",count);
        return map;
    }

    @Override
    public int insertAnswer(Answer answer) {
        //选择题答案列表
        String select = answer.getSelectAnswer();
        //填空题答案列表
        String completion = answer.getCompletionAnswer();
        //试卷ID
        int paperId = answer.getPaperId();

        //将字符串转换成集合
        List<String> selectList = PaperUtils.String2List(select.substring(0,select.length()-1));
        List<String> completionList = PaperUtils.String2List(completion.substring(0,completion.length()-1));

        //根据试卷的ID查询试卷的相信信息
        Paper p = paperMapper.selectByPrimaryKey(paperId);
        //遍历试卷中存放的选择题ID并根据ID查询选择题的详细信息存放在list中
        List<SelectQuestion> selectQuestionList = selectQuestionMapper.selectBatchIds(PaperUtils.getQuestionIds(p.getSelectList()));
        //遍历试卷中存放的填空题ID并根据ID查询填空题的详细信息存放在list中
        List<CompletionQuestion> completionQuestionList = completionQuestionMapper.selectBatchIds(PaperUtils.getQuestionIds(p.getCompletionList()));
        int score = 0;

        //计算考试分数
        for (int i = 0 ; i <selectList.size();i++){
            if(selectList.get(i).toUpperCase().equals(selectQuestionList.get(i).getAnswer().toUpperCase())){
                score+=10;
            }else{
                continue;
            }
        }
        for(int i =0 ;i<completionList.size();i++){
            if(completionList.get(i).toUpperCase().equals(completionQuestionList.get(i).getAnswer())){
                score+=20;
            }else{
                continue;
            }
        }
        answer.setState(1);
        answer.setScore(score);
        return answerMapper.insertSelective(answer);
    }
}
