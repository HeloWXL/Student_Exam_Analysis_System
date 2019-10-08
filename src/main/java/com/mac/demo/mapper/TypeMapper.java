package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypeMapper extends BaseMapper<Type> {
    /**
     * 根据ID删除题目类型
     * @param typeId
     * @return
     */
    int deleteByPrimaryKey(Integer typeId);

    /**
     * 添加题目类型
     * @param record
     * @return
     */
    int insertSelective(Type record);
    /**
     * 根据ID删除题目类型
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Type record);

    Type selectByPrimaryKey(Integer typeId);

    /**
     * 获取题目类型列表
     * @param page
     * @param limit
     * @return
     */
    @Select("select * from type limit #{page},#{limit}")
    List<Type> getTypeList(@Param("page") Integer page, @Param("limit") Integer limit);

    /**
     * 获取题目类型数量
     * @return
     */
    @Select("select count(1) from type")
    int getTypeCount();
}