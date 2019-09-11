package com.mac.demo.service.impl;

import com.mac.demo.mapper.AdminMapper;
import com.mac.demo.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname AdminServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:46 上午
 * @Created by wangxianlin
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
}
