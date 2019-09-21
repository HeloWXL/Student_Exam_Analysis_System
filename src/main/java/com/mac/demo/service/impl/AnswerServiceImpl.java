package com.mac.demo.service.impl;

import com.mac.demo.mapper.AnswerMapper;
import com.mac.demo.service.AnswerService;
import com.mac.demo.vo.AnswerStudentPaperVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String,Object> getAnswerStudentPaperVo(Integer page, Integer limit) {
        List<AnswerStudentPaperVo> list = answerMapper.getAnswerStudentPaperVo((page-1)*limit,limit);
        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        int count = answerMapper.getAnswerCount();
        map.put("count",count);
        return map;
    }
}
