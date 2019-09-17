package com.mac.demo.service;

import com.mac.demo.model.Paper;
import com.mac.demo.vo.PaperTestAdminVo;


import java.util.List;
import java.util.Map;

/**
 * @Classname PaperService
 * @Description TODO
 * @Date 2019/9/12 12:43 上午
 * @Created by wangxianlin
 */
public interface PaperService {

    /**
     * 删除试卷
     * @param paperId
     * @return
     */
    int deleteByPrimaryKey(Integer paperId);

    /**
     * 添加试卷
     * @param record
     * @return
     */
    int insertSelective(Paper record);

    /**
     * 修改试卷
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Paper record);

    /**
     * 获取试卷列表
     * @param page
     * @param limit
     * @return
     */
    Map<String,Object> getPaper(Integer page, Integer limit);

    /**
     * 学生获取考试列表
     * @param testId
     * @return
     */
    List<PaperTestAdminVo> getPaperByTestId(Integer testId);

    /**
     * 自动组卷
     * @param selectNum
     * @param completionNum
     * @return
     */
    Integer getPaperByAuto(Paper paper ,Integer selectNum, Integer completionNum);
}
