package com.mac.demo.service.impl;

import com.mac.demo.mapper.LoginLogMapper;
import com.mac.demo.model.LoginLog;
import com.mac.demo.service.LoginLogService;
import com.mac.demo.vo.LoginLogStudentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname LoginLogServiceImpl
 * @Description TODO
 * @Date 2019/10/13 2:30 下午
 * @Created by wangxianlin
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public int insertLoginLog(LoginLog loginLog) {
        return loginLogMapper.insertSelective(loginLog);
    }

    @Override
    public Map<String,Object> getLoginLog(Integer page, Integer limit) {
        Map<String,Object> map = new HashMap<>();
        List<LoginLogStudentVo> list = loginLogMapper.getLoginLog((page-1)*limit,limit);
        int count = loginLogMapper.getLoginLogCount();
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        map.put("msg","获取登录日志成功");
        return map;
    }
}
