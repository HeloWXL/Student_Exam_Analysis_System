package com.mac.demo.service.impl;

import com.mac.demo.service.SelectQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname SelectQuestionServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:54 上午
 * @Created by wangxianlin
 */
@Service
public class SelectQuestionServiceImpl implements SelectQuestionService {
    @Resource
    private SelectQuestionMapper selectQuestionMapper;
}
