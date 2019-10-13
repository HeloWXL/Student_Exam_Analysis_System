package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Admin;
import com.mac.demo.vo.LoginLogStudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    int deleteByPrimaryKey(Integer adminId);

    /**
     * 管理员添加
     * @param record
     * @return
     */
    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    @Select("select * from admin  limit #{page},#{limit}")
    List<Admin> getAdmin(@Param("page") Integer page, @Param("limit") Integer limit);

    @Select("select count(*) from admin")
    int getAdminCount();

    /**
     * 管理员登录
     * @param adminName
     * @return
     */
    @Select("select * from admin where admin_name = #{adminName}")
    Admin checkLogin(String adminName);

    /**
     * 修改学生密码
     * @param passWord
     * @param adminId
     * @return
     */
    @Update("update admin set admin_password=#{passWord} where admin_id = #{adminId}")
    int changePassWord(String passWord ,int adminId);
}