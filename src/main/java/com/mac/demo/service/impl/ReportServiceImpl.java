package com.mac.demo.service.impl;

import com.mac.demo.mapper.ReportMapper;
import com.mac.demo.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

}
