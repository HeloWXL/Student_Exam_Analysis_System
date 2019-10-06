package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Paper;
import com.mac.demo.vo.PaperTestAdminVo;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface PaperMapper extends BaseMapper<Paper> {


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

    /**
     * 根据试卷的ID查询试卷信息
     * @param paperId
     * @return
     */
    Paper selectByPrimaryKey(Integer paperId);

    /**
     * 修改试卷
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Paper record);

    /**
     * 页面加载与条件查询
     * @authtor: yechengchao
     * @param paperTestAdminVo
     * @return
     */
    List<PaperTestAdminVo> getPaper(PaperTestAdminVo paperTestAdminVo);

    int getPaperCount();

    /**
     * 学生获取试卷列表
     * @return
     */
    @Select("select p.paper_name , p.paper_id ,p.create_time ,p.state ,a.admin_name ,t.test_name,t.time\n" +
            "from paper p , admin a , test t\n" +
            "where p.admin_id = a.admin_id and t.test_id = p.test_id  and p.state = 1 and t.test_id = #{testId}\n")
    List<PaperTestAdminVo> getPaperByTestId(Integer testId);

    @Select("update paper set state = 1 where paper_id = #{paperId}")
    Integer setPaperStateOpen(Integer paperId);

    @Select("update paper set state = 0 where paper_id = #{paperId}")
    Integer setPaperStateClose(Integer paperId);
}