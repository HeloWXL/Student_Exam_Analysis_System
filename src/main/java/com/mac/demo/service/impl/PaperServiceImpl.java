package com.mac.demo.service.impl;

import com.mac.demo.mapper.CompletionQuestionMapper;
import com.mac.demo.mapper.PaperMapper;
import com.mac.demo.mapper.SelectQuestionMapper;
import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.model.Paper;
import com.mac.demo.model.SelectQuestion;
import com.mac.demo.service.PaperService;
import com.mac.demo.utils.PaperUtils;
import com.mac.demo.vo.PaperTestAdminVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname PaperServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:53 上午
 * @Created by wangxianlin
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Resource
    private PaperMapper paperMapper;

    @Resource
    private SelectQuestionMapper selectQuestionMapper;

    @Resource
    private CompletionQuestionMapper completionQuestionMapper;

    @Override
    public int deleteByPrimaryKey(Integer paperId) {
        return paperMapper.deleteByPrimaryKey(paperId);
    }

    @Override
    public int insertSelective(Paper record) {
        return paperMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Paper record) {
        return paperMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Map<String, Object> getPaper(Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        List<PaperTestAdminVo>  list = paperMapper.getPaper((page-1)*limit,limit);
        map.put("data",list);
        int count = paperMapper.getPaperCount();
        map.put("count",count);
        return map;
    }

    @Override
    public List<PaperTestAdminVo> getPaperByTestId(Integer testId) {
        return paperMapper.getPaperByTestId(testId);
    }



    /**
     * 从题库中id集合抽取随机id集合
     * @param oldids
     * @param number
     * @return
     */
    public String getIds(List<Integer> oldids,int number){
        return PaperUtils.autoQustionId(oldids,number);
    }


    @Override
    public Integer getPaperByAuto(Paper paper ,Integer selectNum, Integer completionNum) {
        //类型集合
        int[] typeArray = new int[]{1,2,3,4,5};

        //该map用于存放随机的各类型题号
        Map<Object,Object> map=new HashMap();

        //存放选择题 ID
        StringBuilder selectString = new StringBuilder();
        //存放填空题ID
        StringBuilder completionString = new StringBuilder();
        //遍历题目类型ID 获取随机选择题和填空题数量
        for(int i = 0 ;i<typeArray.length;i++){
            //获取随机选择题id的集合
            List<Integer> sqids=new ArrayList<>();
            for(SelectQuestion selectQuestion:selectQuestionMapper.getSelectByTypeId(typeArray[i])){
                sqids.add(selectQuestion.getSelectId());
            }

            List<Integer> cqids=new ArrayList<>();
            for(CompletionQuestion completionQuestion:completionQuestionMapper.getSelectByTypeId(typeArray[i])){
                cqids.add(completionQuestion.getTypeId());
            }
            selectString.append(getIds(sqids,selectNum));
            completionString.append(getIds(cqids,completionNum));
        }
        map.put("sds",selectString.substring(0,selectString.length()-1));
        map.put("cds",completionString.substring(0,completionString.length()-1));

        //添加到数据库中
        paper.setCompletionList(completionString.toString());
        paper.setSelectList(selectString.toString());
        Integer i = paperMapper.insertSelective(paper);
        return i;
    }
}
