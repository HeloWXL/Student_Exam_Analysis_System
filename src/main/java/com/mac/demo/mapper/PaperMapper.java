package com.mac.demo.mapper;

import com.mac.demo.model.Paper;
import com.mac.demo.vo.PaperTestAdminVo;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface PaperMapper {


    /**
     * 删除试卷
     * @param paperId
     * @return
     */
    int deleteByPrimaryKey(Integer paperId);

    /**
     * 添加试卷
     * @param record
     * @return
     */
    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer paperId);

    /**
     * 修改试卷
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Paper record);

    @Select("select p.paper_name , p.create_time ,a.admin_name ,t.test_name,t.time\n" +
            "from paper p , admin a , test t\n" +
            "where p.admin_id = a.admin_id and t.test_id = p.test_id \n" +
            "limit #{page},#{limit}")
    List<PaperTestAdminVo> getPaper(Integer page,Integer limit);

    @Select("select count(1) from paper")
    int getPaperCount();


}