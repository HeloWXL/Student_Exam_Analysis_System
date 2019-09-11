package com.mac.demo.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * @author wangxl
 * @ClassName MyBatisPlus
 * @Description TODO
 * @date 2019/9/7 17:46
 * @Version 1.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.mac.demo.mapper")
public class MyBatisPlus {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
      return new PaginationInterceptor();
    }

    /**
     * 打印 sql
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
      PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
      //格式化sql语句
      Properties properties = new Properties();
      properties.setProperty("format", "true");
      performanceInterceptor.setProperties(properties);
      return performanceInterceptor;
    }

}
