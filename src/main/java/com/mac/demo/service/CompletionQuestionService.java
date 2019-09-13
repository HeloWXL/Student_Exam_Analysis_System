package com.mac.demo.service;

import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.vo.CompletionCourseVo;

import java.util.List;
import java.util.Map;

/**
 * @Classname CompletionQuestionService
 * @Description TODO
 * @Date 2019/9/12 12:42 上午
 * @Created by wangxianlin
 */
public interface CompletionQuestionService {
    /**
     * 分页查询填空题
     * @param page
     * @param limit
     * @return
     */
    Map<String,Object> getCompletionQuestion(Integer page, Integer limit);
}
