package com.mac.demo.service.impl;

import com.mac.demo.mapper.CompletionQuestionMapper;
import com.mac.demo.service.CompletionQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname CompletionServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:49 上午
 * @Created by wangxianlin
 */
@Service
public class CompletionQuestionServiceImpl implements CompletionQuestionService {
    @Resource
    private CompletionQuestionMapper completionQuestionMapper;

}
