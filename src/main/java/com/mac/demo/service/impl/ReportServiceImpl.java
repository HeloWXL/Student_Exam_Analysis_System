package com.mac.demo.service.impl;

import com.mac.demo.mapper.ReportMapper;
import com.mac.demo.service.ReportService;
import com.mac.demo.vo.QuerySelectQuestionVo;
import com.mac.demo.vo.ReportVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname ReportServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:53 上午
 * @Created by wangxianlin
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportMapper reportMapper;

    @Override
    public Map<String, Object> getReport(ReportVo reportVo) {
        Map<String, Object> map = new HashMap<>();
        reportVo.setPage((reportVo.getPage()-1)*(reportVo.getLimit()));
        List<ReportVo> list = reportMapper.getReport(reportVo);
        map.put("data",list);
        int count = reportMapper.getReportCount();
        map.put("count",count);
        return map;
    }
}
