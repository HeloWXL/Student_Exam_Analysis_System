package com.mac.demo.mapper;

import com.mac.demo.model.CompletionQuestion;

public interface CompletionQuestionMapper {
    int deleteByPrimaryKey(Integer completionId);

    int insert(CompletionQuestion record);

    int insertSelective(CompletionQuestion record);

    CompletionQuestion selectByPrimaryKey(Integer completionId);

    int updateByPrimaryKeySelective(CompletionQuestion record);

    int updateByPrimaryKey(CompletionQuestion record);
}