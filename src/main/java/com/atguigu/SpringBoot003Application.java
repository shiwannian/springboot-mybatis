package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement 开启声明式事务
@EnableTransactionManagement
//@MapperScan("com.atguigu.dao")//生成dao的代理对象 有@Mapper注解就不用扫描了
@SpringBootApplication
//@EnableScheduling //开启定时任务,spring底层集成Quertz
@EnableScheduling
/**
 * SpringBootApplication 上使用@ServletComponentScan 注解后
 * Servlet可以直接通过@WebServlet注解自动注册
 * Filter可以直接通过@WebFilter注解自动注册
 * Listener可以直接通过@WebListener 注解自动注册
 */
@ServletComponentScan
public class SpringBoot003Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot003Application.class,args);
    }
}
