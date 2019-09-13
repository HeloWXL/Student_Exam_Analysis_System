package com.mac.demo.service.impl;

import com.mac.demo.mapper.CompletionQuestionMapper;
import com.mac.demo.service.CompletionQuestionService;
import com.mac.demo.vo.CompletionCourseVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String,Object> getCompletionQuestion(Integer page, Integer limit) {
        Map<String,Object> map = new HashMap<>();
        List<CompletionCourseVo> list = completionQuestionMapper.getCompletionQuestion(page,limit);
        map.put("data",list);
        int count = completionQuestionMapper.getCompletionQuestionCount();
        map.put("count",count);
        return map;
    }
}
