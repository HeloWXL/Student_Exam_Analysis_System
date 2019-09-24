package com.mac.demo.service;

import com.mac.demo.vo.ReportVo;

import java.util.Map;

/**
 * @Classname ReportService
 * @Description TODO
 * @Date 2019/9/12 12:43 上午
 * @Created by wangxianlin
 */
public interface ReportService {
    Map<String, Object> getReport(ReportVo reportVo);

    ReportVo getReportIndex(Integer studentId, Integer paperId);
}
