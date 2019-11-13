package com.czxy.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author xuhongzu
 * @version 1.0
 * @date 2019/11/12
 */
@SpringBootApplication
@MapperScan(basePackages = "com.czxy.changgou.mapper")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
