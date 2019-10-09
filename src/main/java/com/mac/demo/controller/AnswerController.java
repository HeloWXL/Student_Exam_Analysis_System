package com.mac.demo.controller;

import com.mac.demo.model.Answer;
import com.mac.demo.model.Student;
import com.mac.demo.service.AnswerService;
import com.mac.demo.service.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Classname AnswerController
 * @Description TODO
 * @Date 2019/9/12 12:59 上午
 * @Created by wangxianlin
 */
@Api(tags = "答案接口")
@RequestMapping("answer")
@Controller
public class AnswerController {

  @Resource
  private AnswerService answerService;
  @Resource
  private PaperService paperService;

  @ApiOperation("获取答案列表")
  @PostMapping("/getAnswerStudentPaperVo")
  @ResponseBody
  public Map<String, Object> getAnswerStudentPaperVo(Integer page, Integer limit) {
    Map<String, Object> map = answerService.getAnswerStudentPaperVo(page, limit);
    map.put("code", 0);
    map.put("msg", "");
    return map;
  }


  @ApiOperation("提交答案")
  @PostMapping("/insertAnswer")
  @ResponseBody
  public int insertAnswer(@RequestBody Answer answer, HttpServletRequest request) {
    Student student = (Student) request.getSession().getAttribute("student");
    answer.setStudentName(student.getStudentName());
    return answerService.insertAnswer(answer);
  }


}
