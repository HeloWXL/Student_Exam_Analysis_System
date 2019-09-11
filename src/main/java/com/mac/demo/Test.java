package com.mac.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/9/11 11:33 下午
 * @Created by wangxianlin
 */
@Controller
public class Test {

    @RequestMapping("/test")
    public String test(){
        return "admin/test";
    }
}
