package com.mac.demo.service;

import com.mac.demo.model.Test;
import com.mac.demo.vo.TestAdminVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Classname TestService
 * @Description TODO
 * @Date 2019/9/12 12:46 上午
 * @Created by wangxianlin
 */
public interface TestService {

    /**
     * 删除考试
     * @param testId
     * @return
     */
    int deleteByTest(Integer testId);

    /**
     * 发布考试
     * @param record
     * @return
     */
    int insertTest(Test record);

    /**
     * 修改考试
     * @param record
     * @return
     */
    int updateByTest(Test record);

    /**
     * 获取考试列表  -分页
     * @param page
     * @param limit
     * @return
     */
    Map<String,Object> getTest(TestAdminVo testAdminVo);

    /**
     * 学生端展示考试列表
     * @return
     */
    List<Test> getTest();
}
