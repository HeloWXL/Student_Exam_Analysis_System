package com.mac.demo.service;

import com.mac.demo.model.SelectQuestion;

import java.util.Map;

/**
 * @Classname SelectQuestionService
 * @Description TODO
 * @Date 2019/9/12 12:46 上午
 * @Created by wangxianlin
 */
public interface SelectQuestionService {


    /**
     * 获取选择题列表
     * @param page
     * @param limit
     * @return
     */
    Map<String,Object> getSelectQuestion(Integer page, Integer limit);

    /**
     * 根据ID删除选择题
     * @param selectId
     * @return
     */
    int deleteByPrimaryKey(Integer selectId);

    /**
     * 添加选择题
     * @param record
     * @return
     */
    int insertSelective(SelectQuestion record);

    /**
     * 根据ID修改选择题
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SelectQuestion record);
}
