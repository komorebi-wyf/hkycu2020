package com.wyf.ycu.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyf.ycu.mybatis.mapper")
public class YcuMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(YcuMybatisApplication.class, args);
    }

}
