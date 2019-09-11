package com.mac.demo.service.impl;

import com.mac.demo.mapper.TestMapper;
import com.mac.demo.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname TestServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:56 上午
 * @Created by wangxianlin
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;

}
