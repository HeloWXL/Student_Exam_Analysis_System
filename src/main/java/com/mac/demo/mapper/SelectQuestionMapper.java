package com.mac.demo.mapper;

import com.mac.demo.model.SelectQuestion;

public interface SelectQuestionMapper {
    int deleteByPrimaryKey(Integer selectId);

    int insert(SelectQuestion record);

    int insertSelective(SelectQuestion record);

    SelectQuestion selectByPrimaryKey(Integer selectId);

    int updateByPrimaryKeySelective(SelectQuestion record);

    int updateByPrimaryKey(SelectQuestion record);
}