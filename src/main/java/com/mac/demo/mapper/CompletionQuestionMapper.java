package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.vo.CompletionCourseTypeVo;
import com.mac.demo.vo.QueryCompletionQuestionVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.INTERNAL;

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

    /**
     * 跟填空题的ID获取填空题的详细信息
     * @param completionId
     * @return
     */
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

    /**
     * 根据课程的ID获取选择题
     * @param courseId
     * @return
     */
    @Select("select * from completionquestion where  course_id =#{courseId}")
    List<CompletionQuestion> getComppletionBycourseId( Integer courseId);


    /**
     * 根据课程的ID获取选择题的数量
     * @param courseId
     * @return
     */
    @Select("select count(*) from completionquestion where  course_id =#{courseId}")
    int getCompletionoCountBycourseId( Integer courseId);

    void importCompletionQuestion(CompletionCourseTypeVo completionQuestionVo);

    @Select("SELECT course_id FROM course where course_name= #{courseName}")
    Integer findCourseIdByName(String courseName);
    @Select("SELECT type_id FROM type where type_name=#{typeName}")
    Integer findTypeIdByName(String typeName);

    @Insert("Insert into course(course_name) VALUES(#{courseName})")
    Integer insertNOCourse(String courseName);

    @Insert("Insert into type(type_name) VALUES(#{typeName})")
    void insertNoType(String typeName);
}