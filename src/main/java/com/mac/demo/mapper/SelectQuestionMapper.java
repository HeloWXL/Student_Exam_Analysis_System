package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.SelectQuestion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelectQuestionMapper extends BaseMapper<SelectQuestion> {
    int deleteByPrimaryKey(Integer selectId);


    int insertSelective(SelectQuestion record);

    SelectQuestion selectByPrimaryKey(Integer selectId);

    int updateByPrimaryKeySelective(SelectQuestion record);

    int updateByPrimaryKey(SelectQuestion record);
}