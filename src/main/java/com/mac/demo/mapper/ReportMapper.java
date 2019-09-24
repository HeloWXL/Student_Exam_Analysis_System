package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Report;
import com.mac.demo.vo.ReportVo;

import java.util.List;

public interface ReportMapper  extends BaseMapper<Report> {
    int deleteByPrimaryKey(Integer reportId);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer reportId);

    List<ReportVo> getReport(ReportVo reportVo);

    int getReportCount();
}