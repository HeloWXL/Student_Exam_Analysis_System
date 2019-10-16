package com.mac.demo.service.impl;

import com.mac.demo.mapper.*;
import com.mac.demo.model.*;
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
  private CompletionQuestionMapper completionQuestionMapper;
  @Resource
  private PaperMapper paperMapper;
  @Resource
  private ReportMapper reportMapper;
  @Resource
  private SelectQuestionMapper selectQuestionMapper;
  @Resource
  private TypeMapper typeMapper;

  @Override
  public Map<String, Object> getAnswerStudentPaperVo(Integer page, Integer limit) {
    List<AnswerStudentPaperVo> list = answerMapper.getAnswerStudentPaperVo((page - 1) * limit, limit);
    Map<String, Object> map = new HashMap<>();
    map.put("data", list);
    int count = answerMapper.getAnswerCount();
    map.put("count", count);
    return map;
  }


  /**
   * 思路：首先读取前端传输过来的答案
   * 1.分别是选择题和填空题----然后与标准答案进行比较
   *
   * @param answer
   * @return
   */
  @Override
  public int insertAnswer(Answer answer) {
    //选择题答案列表
    String select = answer.getSelectAnswer();
    //填空题答案列表
    String completion = answer.getCompletionAnswer();
    //试卷ID
    int paperId = answer.getPaperId();

    StringBuilder correctSelect = new StringBuilder();
    StringBuilder correctCompletion = new StringBuilder();

    //存放 知识点
    StringBuilder knowledgeList = new StringBuilder();
    //存放 能力
    StringBuilder abilityList = new StringBuilder();

    //将字符串转换成集合 -----选择题答案  ----我的
    List<String> selectList = PaperUtils.String2List(select.substring(0, select.length() - 1));
    //填空题答案 ----我的
    List<String> completionList = PaperUtils.String2List(completion.substring(0, completion.length() - 1));

    //根据试卷的ID查询试卷的相信信息
    Paper p = paperMapper.selectByPrimaryKey(paperId);
    //选择题分数
    int selectScore = p.getSelectScore();
    //填空题分数
    int completionScore = p.getCompletionScore();

    //遍历试卷中存放的选择题ID并根据ID查询选择题的详细信息存放在list中
    List<SelectQuestion> selectQuestionList = selectQuestionMapper.selectBatchIds(PaperUtils.getQuestionIds(p.getSelectList()));
    //遍历试卷中存放的填空题ID并根据ID查询填空题的详细信息存放在list中
    List<CompletionQuestion> completionQuestionList = completionQuestionMapper.selectBatchIds(PaperUtils.getQuestionIds(p.getCompletionList()));
    //定义考试分数
    int score = 0;

    //循环遍历选择题  ---- 计算考试分数
    for (int i = 0; i < selectList.size(); i++) {
      /**
       * 需要存放到report数据库中
       */
      //知识点
      abilityList.append(typeMapper.selectByPrimaryKey(selectQuestionList.get(i).getTypeId()).getTypeName() + ",");
      //能力
      knowledgeList.append(selectQuestionList.get(i).getKnowledge() + ",");
      //选择题正确答案
      correctSelect.append(selectQuestionList.get(i).getAnswer().toUpperCase() + ",");
      //答案比较
      if (selectList.get(i).toUpperCase().equals(selectQuestionList.get(i).getAnswer().toUpperCase())) {
        score += selectScore;
      } else {
        continue;
      }
    }
    //循环遍历填空题   ---计算 分数
    for (int i = 0; i < completionList.size(); i++) {
      correctCompletion.append(completionQuestionList.get(i).getAnswer() + ",");
      if (completionList.get(i).toUpperCase().equals(completionQuestionList.get(i).getAnswer())) {
        score += completionScore;
      } else {
        continue;
      }
    }
    answer.setState(1);
    answer.setScore(score);

    /**
     *  将答案信息添加到我的报告中
     *  创建报告对象
     */
    Report report = new Report();
    String className;
    //试卷ID
    report.setPaperId(paperId);
    //报告名称
    report.setReportName(answer.getStudentName() + "的报告");
    //学生ID
    report.setStudentId(answer.getStudentId());

    //我的答案 ---选择题 和  填空题
    report.setAnswerSelect(select);
    report.setAnswerCompletion(completion);
    //我的考试成绩
    report.setScore(score);

    //按照成绩分配班级
    if (score >= 80) {
      className = "尖子班";
    } else if (score > 60 && score < 80) {
      className = "中级班";
    } else {
      className = "普通班";
    }
    report.setClassName(className);
    //标准答案
    report.setCorrectCompletion(correctCompletion.toString());
    report.setCorrectSelect(correctSelect.toString());
    //知识点存入数据库----选择题
    report.setKnowledge(knowledgeList.toString());
    //能力存入数据库  ----选择题
    report.setAbility(abilityList.toString());
    //将我的答案信息添加到我的报告中
    reportMapper.insertSelective(report);
    return answerMapper.insertSelective(answer);
  }

  @Override
  public Integer getAnswerByStudentIdAndPaperId(Integer studentId, Integer paperId) {
    return answerMapper.getAnswerByStudentIdAndPaperId(studentId,paperId);
  }


}
