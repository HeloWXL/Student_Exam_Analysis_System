package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.SelectQuestion;
import com.mac.demo.vo.QuerySelectQuestionVo;
import com.mac.demo.vo.SelectCourseTypeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SelectQuestionMapper extends BaseMapper<SelectQuestion> {
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

    SelectQuestion selectByPrimaryKey(Integer selectId);

    /**
     * 获取选择题列表
     *
     */

    List<QuerySelectQuestionVo> getSelectQuestion(QuerySelectQuestionVo querySelectQuestionVo);

    /**
     * 获取选择题数量
     * @return
     */

    int getSelectQuestionCount();

    @Select("select * from selectquestion where type_id=#{typeId}")
    List<SelectQuestion> getSelectByTypeId(Integer typeId);

}