package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Student;
import com.mac.demo.vo.QueryStudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 根据ID删除学生
     * @param studentId
     * @return
     */
    int deleteByPrimaryKey(Integer studentId);

    /**
     * 添加学生
     * @param record
     * @return
     */
    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    /**
     * 根据ID修改学生
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * 学生登录  ---根据手机号查询学生信息
     * @param phone
     * @return
     */
    @Select("select * from student where student_phone = #{phone}")
    Student selectStudentByPhone(String phone);

    /**
     * 根据id 得到学生的姓名
     * @param studentId
     * @return
     */
    @Select("select student_name from student where student_id = #{studentId}")
    String getStudentNameById(Integer studentId);

    /***
     * @Author wangxl
     * @Description //获取今天注册的学生
     * @Date 12:46 上午 2019/10/15
     * @Param []
     * @return int
     **/
    @Select("SELECT count(*)  FROM student WHERE TO_DAYS(NOW()) ;")
    int getStudentNowDayCount();

    /***
     * @Author wangxl
     * @Description //获取昨天注册的学生
     * @Date 12:47 上午 2019/10/15
     * @Param []
     * @return int
     **/
    @Select("SELECT count(*)  FROM student WHERE TO_DAYS(NOW())-TO_DAYS(create_time) = 1 ;")
    int getStudentBeforeDayCount();

    /***
     * @Author wangxl
     * @Description //获取这个星期内注册的学生
     * @Date 12:51 上午 2019/10/15
     * @Param []
     * @return int
     **/
    @Select("SELECT count(*)  FROM student WHERE create_time>=DATE_SUB(NOW(),INTERVAL 7 DAY)")
    int getStudent7DayCount();

    /***
     * @Author wangxl
     * @Description //获取这个月注册的学生
     * @Date 12:52 上午 2019/10/15
     * @Param []
     * @return int
     **/
    @Select("SELECT count(*) as num FROM student where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(create_time)")
    int getStudent30DayCount();


    List<Student> getStudentByCondition(QueryStudentVo queryStudentVo);


    int getStudentByConditionCount(QueryStudentVo queryStudentVo);
}