package com.mac.demo.service.impl;

import com.mac.demo.mapper.PaperMapper;
import com.mac.demo.model.Paper;
import com.mac.demo.service.PaperService;
import com.mac.demo.vo.PaperTestAdminVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
