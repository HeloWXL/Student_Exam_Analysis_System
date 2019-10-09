package com.mac.demo.service;

import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.vo.QueryCompletionQuestionVo;

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
     * @return
     */
    Map<String,Object> getCompletionQuestion(QueryCompletionQuestionVo queryCompletionQuestionVo);

    /**
     * 添加填空题
     * @param record
     * @return
     */
    int insertSelective(CompletionQuestion record);


    /**
     * 根据填空题的ID修改填空题
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CompletionQuestion record);

    /**
     * 根据ID删除填空题
     * @param completionId
     * @return
     */
    int deleteByPrimaryKey(Integer completionId);

    void importCompletionQuestion(List<List<String>> listContent);
}
