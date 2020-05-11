package com.znsd.sportslog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.znsd.sportslog.dao")
@SpringBootApplication
public class SportsLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsLogApplication.class, args);
    }

}
