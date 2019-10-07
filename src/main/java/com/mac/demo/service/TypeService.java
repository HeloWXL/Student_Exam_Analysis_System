package com.mac.demo.service;

import com.mac.demo.model.Type;

import java.util.List;
import java.util.Map;

/**
 * @Classname TypeService
 * @Description TODO
 * @Date 2019/9/12 12:46 上午
 * @Created by wangxianlin
 */
public interface TypeService {
    /**
     * 添加题目类型
     * @param record
     * @return
     */
    int insertSelective(Type record);

    /**
     * 获取题目类型列表
     * @param page
     * @param limit
     * @return
     */
    Map<String,Object> getType(Integer page,Integer limit);

    /**
     * 根据ID删除题目类型
     * @param typeId
     * @return
     */
    int deleteByPrimaryKey(Integer typeId);

    /**
     * 根据ID修改题目类型
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Type record);

    /**
     * 加载能力类型列表
     * @return
     */
    List<Type> getTypeList();
}
