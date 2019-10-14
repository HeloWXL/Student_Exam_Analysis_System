package com.mac.demo.controller;

import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.service.CompletionQuestionService;
import com.mac.demo.utils.ExcelUtil;
import com.mac.demo.vo.QueryCompletionQuestionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;


/**
 * @Classname CompletionQuestionController
 * @Description TODO
 * @Date 2019/9/12 12:59 上午
 * @Created by wangxianlin
 */
@Api(tags = "填空题接口")
@RequestMapping("completionquestion")
@Controller
public class CompletionQuestionController {
    @Resource
    private CompletionQuestionService completionQuestionService;

    @ApiOperation("获取填空题列表-分页")
    @PostMapping("/getCompletionQuestion")
    @ResponseBody
    public Map<String,Object> getCompletionQuestion(@RequestBody QueryCompletionQuestionVo queryCompletionQuestionVo){
        Map<String,Object> map = completionQuestionService.getCompletionQuestion(queryCompletionQuestionVo);
        map.put("msg","");
        map.put("code","0");
        return map;
    }

    @ApiOperation("添加填空题")
    @PostMapping("/insertCompletionQuestion")
    @ResponseBody
    public int insertSelective(@RequestBody CompletionQuestion completionQuestion){
        return completionQuestionService.insertSelective(completionQuestion);
    }

    @ApiOperation("修改填空题")
    @PostMapping("/updateCompletionQuestion")
    @ResponseBody
    public int updateCompletionQuestion(@RequestBody CompletionQuestion completionQuestion) {
        return completionQuestionService.updateByPrimaryKeySelective(completionQuestion);
    }

    @ApiOperation("删除填空题")
    @GetMapping("/deleteCompletionQuestion")
    @ResponseBody
    public int deleteCompletionQuestion(@RequestParam("completionId") Integer completionId) {
        return completionQuestionService.deleteByPrimaryKey(completionId);
    }

    @ApiOperation("批量导入填空题")
    @PostMapping("/uploadCompletionQuestion")
    @ResponseBody
    public  Map<String,Object>  importCompletionQuestion(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String pattern = fileName.substring(fileName.lastIndexOf(".") + 1);
        List<List<String>> listContent = new ArrayList<>();
        String message = "导入成功";

        try {
            if (file != null) {
                //文件类型判断
                if (!ExcelUtil.isEXCEL(file)) {
                    message="文件为空";
                }
                listContent = ExcelUtil.readExcelContents(file, pattern);
                //文件内容判断
                if (listContent.isEmpty()) {

                    message="表格内容为空";
                }
                completionQuestionService.importCompletionQuestion(listContent);
            } else {

                message="未选择文件";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",message);
        map.put("data",fileName);
        return map;
    }

   /* @ApiOperation("批量填空题模板下载")
    @PostMapping("/downloadTemplate")
    @ResponseBody
    public String downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception{

        JSONObject rt = new JSONObject();
        //json对象，用来记录下载状态值，写入log中，也可以把状态值返回到前台，这一部分可有可无。
        rt.put("status", "1");
        rt.put("message", "");
        rt.put("result", "");
        //学生新建excel下载模板保存地址从配置文件中读取
        String folderPath = ResourceBundle.getBundle("systemconfig").getString("stuExcelDownLoadPath") + File.separator + "stuTemplateExcel.xlsx";
        File excelFile = new File(folderPath);
        //判断模板文件是否存在
        if (!excelFile.exists() || !excelFile.isFile()) {
            rt.put("status", "0");
            rt.put("message", "模板文件不存在");

            //  return rt.toJSONString();
        }
        //文件输入流
        FileInputStream fis = null;
        XSSFWorkbook wb = null;
        //使用XSSFWorkbook对象读取excel文件
        try {
            fis = new FileInputStream(excelFile);
            wb = new XSSFWorkbook(fis);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            rt.put("status", "0");
            rt.put("message", "模板文件读取失败");
            // return rt.toJSONString();
        }
        //设置contentType为vnd.ms-excel
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        // 对文件名进行处理。防止文件名乱码，这里前台直接定义了模板文件名，所以就不再次定义了
        //String fileName = CharEncodingEdit.processFileName(request, "stuTemplateExcel.xlsx");
        // Content-disposition属性设置成以附件方式进行下载
        response.setHeader("Content-disposition", "attachment;filename=stuTemplateExcel.xlsx");
        //调取response对象中的OutputStream对象
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            rt.put("status", "0");
            rt.put("message", "模板文件下载失败");
        }
        logger.info("下载学生模板文件结果:" + rt.toJSONString());
        //return rt.toJSONString();
*/
    }

