package com.mac.demo.service.impl;

import com.mac.demo.mapper.AnswerMapper;
import com.mac.demo.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname AnswerServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:47 上午
 * @Created by wangxianlin
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private AnswerMapper answerMapper;
}
