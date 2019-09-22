package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Report;

public interface ReportMapper  extends BaseMapper<Report> {
    int deleteByPrimaryKey(Integer reportId);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer reportId);
}