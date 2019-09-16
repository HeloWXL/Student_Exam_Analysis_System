package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.SelectQuestion;
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
     * @param page
     * @param limit
     * @return
     */
    @Select("select s.select_id ,s.text,s.answer,s.option_a,s.option_b,s.option_c,s.create_time," +
            " s.option_d ,s.knowledge ,s.level , t.type_name,c.course_name from selectquestion s ,course c ,type t where s.course_id = c.course_id" +
            " and s.type_id = t.type_id limit " +
            "#{page},#{limit}")
    List<SelectCourseTypeVo> getSelectQuestion(Integer page, Integer limit);

    /**
     * 获取选择题数量
     * @return
     */
    @Select("select count(1) from selectquestion")
    int getSelectQuestionCount();

    @Select("select * from selectquestion where type_id=#{typeId}")
    List<SelectQuestion> getSelectByTypeId(Integer typeId);

}