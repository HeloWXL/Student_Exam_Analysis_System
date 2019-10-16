package com.mac.demo.service;

import com.mac.demo.model.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Classname AnswerService
 * @Description TODO
 * @Date 2019/9/12 12:41 上午
 * @Created by wangxianlin
 */
public interface AnswerService {

  /**
   * 获取学生答案列表
   *
   * @param page
   * @param limit
   * @return
   */
  Map<String, Object> getAnswerStudentPaperVo(Integer page, Integer limit);


  /**
   * 添加学生的考试信息
   *
   * @param answer
   * @return
   */
  int insertAnswer(Answer answer);

  /***
   * @Author wangxl
   * @Description //根据学生ID和试卷ID查询答案数量
   * @Date 12:42 上午 2019/10/17
   * @Param [studentId, paperId]
   * @return java.lang.Integer
   **/
  Integer getAnswerByStudentIdAndPaperId(Integer studentId, Integer paperId);
}
