package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Course;
import com.mac.demo.model.LoginLog;
import com.mac.demo.vo.LoginLogStudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {

    int insertSelective(LoginLog record);


    /***
     * @Author wangxl
     * @Description //获取登录日志数据
     * @Date 12:22 上午 2019/10/15
     * @Param [page, limit]
     * @return java.util.List<com.mac.demo.vo.LoginLogStudentVo>
     **/
    @Select("select * from login_log log ,student stu where stu.student_id = log.sutdent_id order by create_time desc limit #{page},#{limit}")
    List<LoginLogStudentVo> getLoginLog(@Param("page") Integer page, @Param("limit") Integer limit);

    /***
     * @Author wangxl
     * @Description //获取登录日志数量
     * @Date 4:25 下午 2019/10/13
     * @Param []
     * @return int
     **/
    @Select("select count(*) from login_log log ,student stu where stu.student_id = log.sutdent_id ")
    int getLoginLogCount();
}