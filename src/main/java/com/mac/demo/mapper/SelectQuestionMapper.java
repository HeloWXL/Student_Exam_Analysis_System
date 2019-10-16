package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.SelectQuestion;
import com.mac.demo.vo.QuerySelectQuestionVo;
import com.mac.demo.vo.SelectCourseTypeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.INTERNAL;

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

    /**
     * 根据选择题的ID查询选择题的详细信息
     * @param selectId
     * @return
     */
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

    /**
     * 根据课程的ID获取选择题的数量
     * @param courseId
     * @return
     */
    @Select("select * from selectquestion where course_Id = #{courseId}")
    List<SelectQuestion> getSelectByCourseId(Integer courseId);

    /**
     * 根据课程ID获取选择题的数量
     * @param courseId
     * @return
     */
    @Select("select count(*) from selectquestion where course_Id = #{courseId}")
    int getSelectCountByCourseId(Integer courseId);

    @Select("SELECT course_id FROM course where course_name= #{courseName}")
    Integer findCourseIdByName(String courseName);

    @Insert("Insert into course(course_name) VALUES(#{courseName})")
    void insertNOCourse(String courseName);

    @Select("SELECT type_id FROM type where type_name=#{typeName}")
    Integer findTypeIdByName(String typeName);

    @Insert("Insert into type(type_name) VALUES(#{typeName})")
    void insertNoType(String typeName);

    void importSelect(SelectCourseTypeVo selectCourseTypeVo);
}