package com.znsd.sportsvideo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan的：扫描mapper接口的位置
@MapperScan("com.znsd.sportsvideo.dao")
@SpringBootApplication
public class SportsVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsVideoApplication.class, args);
    }

}
