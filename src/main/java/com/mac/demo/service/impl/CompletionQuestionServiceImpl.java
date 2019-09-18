package com.mac.demo.service.impl;

import com.mac.demo.mapper.CompletionQuestionMapper;
import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.service.CompletionQuestionService;
import com.mac.demo.vo.CompletionCourseTypeVo;
import com.mac.demo.vo.QueryCompletionQuestionVo;
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
    public Map<String,Object> getCompletionQuestion(QueryCompletionQuestionVo queryCompletionQuestionVo) {
        Map<String,Object> map = new HashMap<>();
        queryCompletionQuestionVo.setPage((queryCompletionQuestionVo.getPage()-1)*(queryCompletionQuestionVo.getLimit()));
        List<QueryCompletionQuestionVo> list = completionQuestionMapper.getCompletionQuestion(queryCompletionQuestionVo);
        map.put("data",list);
        int count = completionQuestionMapper.getCompletionQuestionCount();
        map.put("count",count);
        return map;
    }

    /**
     * 添加填空题
     * @param record
     * @return
     */
    @Override
    public int insertSelective(CompletionQuestion record) {
        return completionQuestionMapper.insertSelective(record);
    }

    /**
     * 根据填空题的ID修改填空题
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(CompletionQuestion record) {
        return completionQuestionMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据ID删除填空题
     * @param completionId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer completionId) {
        return completionQuestionMapper.deleteByPrimaryKey(completionId);
    }

}
