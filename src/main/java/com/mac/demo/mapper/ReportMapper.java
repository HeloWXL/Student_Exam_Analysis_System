package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Report;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportMapper extends BaseMapper<Report> {
    int deleteByPrimaryKey(Integer reportId);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer reportId);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);
}