package com.mac.demo.service.impl;

import com.mac.demo.mapper.PaperMapper;
import com.mac.demo.service.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname PaperServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:53 上午
 * @Created by wangxianlin
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Resource
    private PaperMapper paperMapper;

}
