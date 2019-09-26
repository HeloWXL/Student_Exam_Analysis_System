package com.mac.demo.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    /**
     * 根据文档格式返回相应的文档对象
     *
     * @param file
     * @param pattern 文档格式: xls, xlsx
     * @return
     */
    public static Workbook readExcel(MultipartFile file, String pattern) {
        //文档对象
        Workbook workbook = null;
        if (file != null) {
            try {
                //获取输入流
                InputStream is = file.getInputStream();
                if ("xls".equals(pattern)) {
                    //2003版格式-xls
                    return workbook = new HSSFWorkbook(is);
                } else if ("xlsx".equals(pattern)) {
                    //2007及以上版本格式-xlsx
                    return workbook = new XSSFWorkbook(is);
                } else {
                    return null;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return workbook;
    }

    /**
     * 判断上传的文件是否是EXCEL文件
     *
     * @param file
     * @return
     */
    public static Boolean isEXCEL(MultipartFile file) {
        if (file != null) {
            //文件名
            String fileName = file.getOriginalFilename();
            //文件后缀
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            //转小写
            suffix = suffix.toLowerCase();
            if ("xls".equals(suffix) || "xlsx".equals(suffix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解析excel表格单列返回list,
     *
     * @Auther: wangxianlin
     * @Date: 2018/6/29
     */
    public static List<String> excelToList(MultipartFile file, String pattern) {
        List<String> list = new ArrayList<>();
        //文档对象
        Workbook workbook = null;
        //表格对象
        Sheet sheet = null;
        //非空和文件格式判断
        if (isEXCEL(file)) {
            workbook = readExcel(file, pattern);
        }
        if (workbook != null) {
            //获取文档首个表格
            sheet = workbook.getSheetAt(0);
            //获取最大行数
            int rowNum = sheet.getPhysicalNumberOfRows();
            //行对象
            Row row = null;
            //单元格数据
            String cellData = null;
            //跳过第一行标题栏
            for (int i = 1; i < rowNum; i++) {
                //获取第一行
                row = sheet.getRow(i);
                //只取第一列数据
                cellData = row.getCell(0).toString();
                if (StringUtils.isNotBlank(cellData)) {
                    list.add(cellData);
                }
            }
        }
        return list;
    }




    /**
     *
     * @Auther: wangxl
     * @Date: 2018/11/22
     */
    public static List<List<String>> readExcelContents(MultipartFile file, String pattern) {
        List<List<String>> listRow = new ArrayList<>();;
        //文档对象
        Workbook workbook = null;
        //表格对象
        Sheet sheet = null;
        //非空和文件格式判断
        if (isEXCEL(file)) {
            workbook = readExcel(file, pattern);
        }
        if (workbook != null) {
            //获取文档首个表格
            sheet = workbook.getSheetAt(0);
            //获取最大行数
            int rowNum = sheet.getPhysicalNumberOfRows();

            //行对象
            Row row = null;
            //单元格数据
            String cellData = null;
            //跳过第一行标题栏
            for (int i = 1; i < rowNum; i++) {
                row = sheet.getRow(i);
                List<String> listCell = new ArrayList<>();
                if (StringUtils.isBlank(row.getCell(0).toString())){
                    break;
                }

//              ------------------------这边需要修改------------------------
                //遍历列    --- ---   7列数据
                for (int j = 0; j < 7; j++){
                    cellData = row.getCell(j).toString();
                    listCell.add(cellData);
                }
//               --------------------------------------------------------
                listRow.add(listCell);
            }
        }
        return listRow;
    }

}
