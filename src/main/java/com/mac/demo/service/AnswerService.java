package com.mac.demo.service;

import java.util.Map;

/**
 * @Classname AnswerService
 * @Description TODO
 * @Date 2019/9/12 12:41 上午
 * @Created by wangxianlin
 */
public interface AnswerService {
    /**
     * 获取学生答案列表
     * @param page
     * @param limit
     * @return
     */
    Map<String,Object> getAnswerStudentPaperVo(Integer page, Integer limit);

}
