package com.mac.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mac.demo.mapper.SelectQuestionMapper;
import com.mac.demo.model.SelectQuestion;
import com.mac.demo.service.SelectQuestionService;
import com.mac.demo.vo.CompletionCourseTypeVo;
import com.mac.demo.vo.QuerySelectQuestionVo;
import com.mac.demo.vo.SelectCourseTypeVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname SelectQuestionServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:54 上午
 * @Created by wangxianlin
 */
@Service
public class SelectQuestionServiceImpl implements SelectQuestionService {
    @Resource
    private SelectQuestionMapper selectQuestionMapper;

    @Override
    public Map<String, Object> getSelectQuestion(QuerySelectQuestionVo querySelectQuestionVo) {
        Map<String, Object> map = new HashMap<>();
        querySelectQuestionVo.setPage((querySelectQuestionVo.getPage() - 1) * (querySelectQuestionVo.getLimit()));
        List<QuerySelectQuestionVo> list = selectQuestionMapper.getSelectQuestion(querySelectQuestionVo);
        map.put("data", list);
        int count = selectQuestionMapper.getSelectQuestionCount();
        map.put("count", count);
        return map;
    }

    @Override
    public int deleteByPrimaryKey(Integer selectId) {
        return selectQuestionMapper.deleteByPrimaryKey(selectId);
    }

    @Override
    public int insertSelective(SelectQuestion record) {
        return selectQuestionMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SelectQuestion record) {
        return selectQuestionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelectQuestionList(List<List<String>> list) {
        SelectQuestion selectQuestion = new SelectQuestion();
        for (int i = 0; i < list.size(); i++) {
            //选择题题目
            selectQuestion.setText(list.get(i).get(0));
            //选项A
            selectQuestion.setOptionA(list.get(i).get(1));
            //选项B
            selectQuestion.setOptionB(list.get(i).get(2));
            //选项C
            selectQuestion.setOptionC(list.get(i).get(3));
            //选项D
            selectQuestion.setOptionD(list.get(i).get(4));
            //答案
            selectQuestion.setAnswer(list.get(i).get(5));
            //知识点
            selectQuestion.setKnowledge(list.get(i).get(6));
            //能力类型
            switch (list.get(i).get(7)) {
                case "客观分析能力":
                    selectQuestion.setTypeId(1);
                    break;
                case "推理能力":
                    selectQuestion.setTypeId(2);
                    break;
                case "动手能力":
                    selectQuestion.setTypeId(3);
                    break;
                case "计算能力":
                    selectQuestion.setTypeId(4);
                    break;
                case "应用能力":
                    selectQuestion.setTypeId(5);
                    break;
                case "观察能力":
                    selectQuestion.setTypeId(6);
                    break;
                default:
                    selectQuestion.setTypeId(0);
                    break;
            }

        }
        int i = selectQuestionMapper.insertSelective(selectQuestion);
        return i;
    }

    @Override
    public void batchImportSelectquestion(List<List<String>> listContent) {

    }

    @Override
    public void importSelect(List<List<String>> listContent) {

        for (int i = 0; i < listContent.size(); i++) {
            SelectCourseTypeVo selectCourseTypeVo = new SelectCourseTypeVo();

            String text = listContent.get(i).get(0);

            String courseName = listContent.get(i).get(6);
            Integer courseId = selectQuestionMapper.findCourseIdByName(courseName);
            if (courseId != null) {
                selectCourseTypeVo.setCourseId(courseId);
            } else {
                selectQuestionMapper.insertNOCourse(courseName);
                selectCourseTypeVo.setCourseId(selectQuestionMapper.findCourseIdByName(courseName));
            }

            String typeName = listContent.get(i).get(8);
            Integer typeId = selectQuestionMapper.findTypeIdByName(typeName);

            if (typeId != null) {
                selectCourseTypeVo.setTypeId(typeId);
            } else {
                selectQuestionMapper.insertNoType(typeName);
                selectCourseTypeVo.setTypeId(selectQuestionMapper.findTypeIdByName(typeName));
            }

            selectCourseTypeVo.setText(text);
            selectCourseTypeVo.setOptionA(listContent.get(i).get(1));
            selectCourseTypeVo.setOptionB(listContent.get(i).get(2));
            selectCourseTypeVo.setOptionC(listContent.get(i).get(3));
            selectCourseTypeVo.setOptionD(listContent.get(i).get(4));
            selectCourseTypeVo.setAnswer(listContent.get(i).get(5));
            selectCourseTypeVo.setLevel(Integer.parseInt((listContent.get(i).get(7).substring(0, 1))));

            selectCourseTypeVo.setKnowledge(listContent.get(i).get(9));

            System.out.println(selectCourseTypeVo.toString());

            selectQuestionMapper.importSelect(selectCourseTypeVo);

        }

    }
}
