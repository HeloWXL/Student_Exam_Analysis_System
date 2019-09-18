package com.mac.demo.service.impl;

import com.mac.demo.mapper.SelectQuestionMapper;
import com.mac.demo.model.SelectQuestion;
import com.mac.demo.service.SelectQuestionService;
import com.mac.demo.vo.QuerySelectQuestionVo;
import com.mac.demo.vo.SelectCourseTypeVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> getSelectQuestion(QuerySelectQuestionVo querySelectQuestionVo) {
        Map<String, Object> map = new HashMap<>();
        querySelectQuestionVo.setPage((querySelectQuestionVo.getPage()-1)*(querySelectQuestionVo.getLimit()));
        List<QuerySelectQuestionVo> list = selectQuestionMapper.getSelectQuestion(querySelectQuestionVo);
        map.put("data",list);
        int count = selectQuestionMapper.getSelectQuestionCount();
        map.put("count",count);
        return map;
    }

    @Override
    public int deleteByPrimaryKey(Integer selectId) {
        return selectQuestionMapper.deleteByPrimaryKey(selectId);
    }

    @Override
    public int insertSelective(SelectQuestion record) {
        return selectQuestionMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SelectQuestion record) {
        return selectQuestionMapper.updateByPrimaryKeySelective(record);
    }

}
