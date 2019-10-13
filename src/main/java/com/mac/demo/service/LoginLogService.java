package com.mac.demo.service;

import com.mac.demo.model.LoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Classname LoginLogService
 * @Description TODO
 * @Date 2019/10/13 2:29 下午
 * @Created by wangxianlin
 */
public interface LoginLogService {
    /***
     * @Author wangxl
     * @Description //登录日志
     * @Date 2:30 下午 2019/10/13
     * @Param []
     * @return int
     **/
    int insertLoginLog(LoginLog loginLog);

    /***
     * @Author wangxl
     * @Description //分页获取登录日志
     * @Date 4:24 下午 2019/10/13
     * @Param [page, limit]
     * @return java.util.List<com.mac.demo.model.LoginLog>
     **/
    Map<String,Object> getLoginLog(@Param("page") Integer page, @Param("limit") Integer limit);




}
