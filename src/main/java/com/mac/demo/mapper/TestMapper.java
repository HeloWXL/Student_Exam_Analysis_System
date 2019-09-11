package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<Test> {
    int deleteByPrimaryKey(Integer testId);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer testId);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}