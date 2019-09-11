package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Admin;
import com.mac.demo.model.Answer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerMapper extends BaseMapper<Answer> {
    int deleteByPrimaryKey(Integer answerId);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer answerId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
}