package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Paper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperMapper extends BaseMapper<Paper> {
    int deleteByPrimaryKey(Integer paperId);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer paperId);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);
}