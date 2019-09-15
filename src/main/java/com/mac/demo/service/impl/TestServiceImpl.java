package com.mac.demo.service.impl;

import com.mac.demo.mapper.TestMapper;
import com.mac.demo.model.Test;
import com.mac.demo.service.TestService;
import com.mac.demo.vo.TestAdminVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public int deleteByTest(Integer testId) {
        return testMapper.deleteByPrimaryKey(testId);
    }

    @Override
    public int insertTest(Test record) {
        return testMapper.insertSelective(record);
    }

    @Override
    public int updateByTest(Test record) {
        return testMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Map<String, Object> getTest(Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        List<TestAdminVo> list = testMapper.getTest((page-1)*limit,limit);
        map.put("data",list);
        int count = testMapper.getTestCount();
        map.put("count",count);
        return map;
    }
}
