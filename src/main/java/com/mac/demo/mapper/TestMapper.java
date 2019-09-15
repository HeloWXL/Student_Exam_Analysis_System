package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Test;
import com.mac.demo.vo.TestAdminVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.INTERNAL;

import java.util.List;

@Mapper
public interface TestMapper extends BaseMapper<Test> {
    /**
     * 删除考试
     * @param testId
     * @return
     */
    int deleteByPrimaryKey(Integer testId);

    /**
     * 发布考试
     * @param record
     * @return
     */
    int insertSelective(Test record);

    /**
     * 修改考试
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Test record);

    /**
     * 获取考试列表
     * @param page
     * @param limit
     * @return
     */
    @Select("select t.test_id ,t.test_name , t.time , t.create_time ,a.admin_name from test t , admin a where t.admin_id = a.admin_id limit #{page},#{limit}")
    List<TestAdminVo> getTest(Integer page, Integer limit);

    /**
     * 获取考试数量
     * @return
     */
    @Select("select count(1) from test ")
    int getTestCount();

    Test selectByPrimaryKey(Integer testId);

}