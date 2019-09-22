package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Admin;
import com.mac.demo.model.Answer;
import com.mac.demo.vo.AnswerStudentPaperVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnswerMapper extends BaseMapper<Answer> {
    /**
     * 学生提交试卷
     * @param record
     * @return
     */
    int insertSelective(Answer record);

    /**
     * 根据的ID查询学生答案信息
     * @param answerId
     * @return
     */
    Answer selectByPrimaryKey(Integer answerId);


    /**
     * 获取学生答案列表
     * @param page
     * @param limit
     * @return
     */
    @Select("select \n" +
            "s.student_name,s.student_phone ,\n" +
            "a.answer_id,a.completion_answer,a.select_answer,a.score,a.state,\n" +
            "p.paper_name\n" +
            "from student s , answer a , paper p \n" +
            "where s.student_id = a.student_id and p.paper_id = a.paper_id\n" +
            "limit #{page},#{limit}")
    List<AnswerStudentPaperVo> getAnswerStudentPaperVo(Integer page,Integer limit);

    @Select("select count(1) from answer")
    int getAnswerCount ();







}