package com.mac.demo.utils;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 试卷工具类
 */
public class PaperUtils {

    /**
     * 获取题号
     * @param str
     * @return
     */
    public static List<Integer> getQuestionIds(String str){
        List<Integer> _ids=new ArrayList<>();
        if(!str.equals("error")){
            String[] ids=str.split(",");
            for(String id:ids){
                Integer _id=Integer.parseInt(id);
                _ids.add(_id);
            }
        }

        return _ids;
    }

    /**
     * 获取随机试题题号
     * @param ids 数据库获取的题号字符串
     * @param number 题数
     * @return  随机试题集合
     */
    public static String autoQustionId(List<Integer> ids,Integer number){
        String message="";
        if(ids.size()<number){
            message="error";
        }
        else{
            Map map = new HashMap();
            String str="";
            // List listNew = new ArrayList();
            while (map.size() < number) {
                int random = (int) (Math.random() * ids.size());
                if (!map.containsKey(random)) {
                    map.put(random, "");
                    str+=ids.get(random)+",";
                }
            }
//            message=str.substring(0,str.length()-1);
            message = str;
        }
            return message;
    }

    /**
     * 数组转字符串（，隔开）
     * @param message
     * @return
     */
    public static String array2String (String[] message){
        String ids="";
        for(String str:message){
            ids+=str+",";
        }
        ids=ids.substring(0,ids.length()-1);
        return ids;
    }


    /**
     * 字符串转集合
     * @return
     */
    public static List<String> String2List (String str){
        List<String> _ids=new ArrayList<>();
        String[] ids=str.split(",");
        for(String id:ids){
            String _id=id;
            _ids.add(_id);
        }
        return _ids;
    }

    public static List<String> String22List (String str){
        List<String> _ids=new ArrayList<>();
        String[] ids=str.split(",,");
        for(String id:ids){
            String _id=id;
            _ids.add(_id);
        }
        return _ids;
    }



}
