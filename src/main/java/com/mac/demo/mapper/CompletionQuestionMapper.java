package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.vo.CompletionCourseTypeVo;
import com.mac.demo.vo.QueryCompletionQuestionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompletionQuestionMapper extends BaseMapper<CompletionQuestion> {
    /**
     * 根据ID删除填空题
     * @param completionId
     * @return
     */
    int deleteByPrimaryKey(Integer completionId);

    /**
     * 添加填空题
     * @param record
     * @return
     */
    int insertSelective(CompletionQuestion record);

    CompletionQuestion selectByPrimaryKey(Integer completionId);

    int updateByPrimaryKeySelective(CompletionQuestion record);

    /**
     * 分页查询填空题
     *
     * @return
     */

    List<QueryCompletionQuestionVo> getCompletionQuestion(QueryCompletionQuestionVo queryCompletionQuestionVo);

    /**
     * 统计填空题数量
     * @return
     */

    int getCompletionQuestionCount();


    @Select("select * from completionquestion where type_id = #{typeId}")
    List<CompletionQuestion> getSelectByTypeId(Integer typeId);
}