package com.mac.demo.service;

import com.mac.demo.model.Admin;

/**
 * @Classname AdminService
 * @Description TODO
 * @Date 2019/9/12 12:41 上午
 * @Created by wangxianlin
 */
public interface AdminService {
    /**
     * 修改管理员密码
     * @param passWord
     * @param adminId
     * @return
     */
    int changePassWord(String passWord ,int adminId);

    /**
     * 管理员登录
     * @param adminName
     * @return
     */
    Admin checkLogin(String adminName);


    /**
     * 添加管理员
     * @param record
     * @return
     */
    int insertSelective(Admin record);

}
