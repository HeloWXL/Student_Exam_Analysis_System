package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.vo.CompletionCourseVo;
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
     * @param page
     * @param limit
     * @return
     */
    @Select("select completion.completion_id,completion.text,completion.answer,completion.level,completion.knowledge,completion.create_time,c.course_name,t.type_name " +
            "from completionquestion completion ,course c ,type t where c.course_id = completion.course_id and t.type_id = completion.type_id " +
            "limit #{page},#{limit}")
    List<CompletionCourseVo> getCompletionQuestion(Integer page, Integer limit);

    /**
     * 统计填空题数量
     * @return
     */
    @Select("select count(1) from completionquestion")
    int getCompletionQuestionCount();

}