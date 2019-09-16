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
    public Map<Object,Object> getPaperByAuto(Integer typeId, Integer selectNum, Integer completionNum) {
        //该map用于存放随机的各类型题号
        Map<Object,Object> map=new HashMap();
        //试题总分
        double score=0.0;
        //返回信息
        StringBuilder message=new StringBuilder();
        //获取随机选择题id的集合
        List<Integer> sqids=new ArrayList<>();
        for(SelectQuestion selectQuestion:selectQuestionMapper.getSelectByTypeId(typeId)){
            sqids.add(selectQuestion.getSelectId());
        }
        map.put("sds",getIds(sqids,selectNum));

        List<Integer> cqids=new ArrayList<>();
        for(CompletionQuestion completionQuestion:completionQuestionMapper.getSelectByTypeId(typeId)){
            cqids.add(completionQuestion.getTypeId());
        }
        map.put("cds",getIds(cqids,completionNum));

        Paper paper = new Paper();
        paper.setAdminId(1);
        paper.setCompletionList(getIds(cqids,completionNum));
        paper.setPaperName("入学考试");
        paper.setTestId(1);
        paper.setSelectList(getIds(sqids,selectNum));
        paperMapper.insertSelective(paper);
        return map;
    }
}
