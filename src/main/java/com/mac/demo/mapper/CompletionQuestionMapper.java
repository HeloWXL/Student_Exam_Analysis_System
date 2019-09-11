package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.CompletionQuestion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompletionQuestionMapper extends BaseMapper<CompletionQuestion> {
    int deleteByPrimaryKey(Integer completionId);

    int insertSelective(CompletionQuestion record);

    CompletionQuestion selectByPrimaryKey(Integer completionId);

    int updateByPrimaryKeySelective(CompletionQuestion record);

    int updateByPrimaryKey(CompletionQuestion record);
}