package com.lp.tianmimi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lp.tianmimi.dao")
public class APP01 {
    public static void main(String[] args) {
        SpringApplication.run(APP01.class,args);
    }
}
