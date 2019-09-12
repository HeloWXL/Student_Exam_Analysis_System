package com.mac.demo.service.impl;

import com.mac.demo.mapper.AdminMapper;
import com.mac.demo.model.Admin;
import com.mac.demo.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname AdminServiceImpl
 * @Description TODO
 * @Date 2019/9/12 12:46 上午
 * @Created by wangxianlin
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    /**
     * 修改管理员密码
     * @param passWord
     * @param adminId
     * @return
     */
    @Override
    public int changePassWord(String passWord, int adminId) {
        return adminMapper.changePassWord(passWord,adminId);
    }

    /**
     * 管理员登录
     * @param adminName
     * @return
     */
    @Override
    public Admin checkLogin(String adminName) {
        return adminMapper.checkLogin(adminName);
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @Override
    public int insertSelective(Admin admin) {
        return adminMapper.insertSelective(admin);
    }
}
