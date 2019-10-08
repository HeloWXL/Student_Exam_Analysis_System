package com.mac.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mac.demo.model.Report;
import com.mac.demo.vo.ReportVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ReportMapper  extends BaseMapper<Report> {
    int deleteByPrimaryKey(Integer reportId);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer reportId);

    List<ReportVo> getReport(ReportVo reportVo);

    int getReportCount();

    /**
     * 根据试卷的id和学生的id查询 学生成绩报告
     * @param studentId
     * @param paperId
     * @return
     */
    @Select("   SELECT r.*,s.*,p.*\n" +
        "    from report r,student s, paper p\n" +
        "    where r.student_id=s.student_id and r.paper_id=p.paper_id\n" +
        "      and r.student_id=#{studentId} and r.paper_id=#{paperId} ")
    ReportVo getReportIndex(@Param("studentId") Integer studentId, @Param("paperId")Integer paperId);

    @Select("select avg(score)\n" +
        "from report\n" +
        "where paper_id = #{paperId}")
    double getAvgScoreByPaperId(int PaperId);

}