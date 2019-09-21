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
     * 根据试卷的ID获取试卷的信息
     * @param paperId
     * @return
     */
    Paper selectByPrimaryKey(Integer paperId);
    /**
     * 获取试卷列表
     * @return
     */
    Map<String,Object> getPaper(PaperTestAdminVo paperTestAdminVo);

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

    /**
     * 根据试卷的ID 得到 选择题和填空题信息
     * @param paperId
     * @return
     */
    Paper  selectPaper(Integer paperId);

    Integer setPaperStateOpen(Integer paperId);

    Integer setPaperStateClose(Integer paperId);
}
