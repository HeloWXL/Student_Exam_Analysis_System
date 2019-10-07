package com.mac.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mac.demo.mapper.TypeMapper;
import com.mac.demo.model.Type;
import com.mac.demo.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname TypeServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:57 上午
 * @Created by wangxianlin
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeMapper typeMapper;


    /**
     * 根据能力ID查询能力
     * @param typeId
     * @return
     */
    public Type getTypeById(Integer typeId){
        return typeMapper.selectByPrimaryKey(typeId);
    }

    /**
     * 添加题目类型
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Type record) {
        return typeMapper.insertSelective(record);
    }

    /**
     * 获取题目类型列表
     * @param page
     * @param limit
     * @return
     */
    @Override
    public Map<String, Object> getType(Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        List<Type> list = typeMapper.getTypeList((page-1)*limit,limit);
        map.put("data",list);
        System.out.println(list.size());
        int count = typeMapper.getTypeCount();
        map.put("count",count);
        return map;
    }

    /**
     * 根据ID删除题目类型
     * @param typeId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer typeId) {
        return typeMapper.deleteByPrimaryKey(typeId);
    }

    /**
     * 根据ID修改题目类型
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Type record) {
        return typeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Type> getTypeList() {
        EntityWrapper en  = new EntityWrapper();
        return typeMapper.selectList(en);
    }


}
