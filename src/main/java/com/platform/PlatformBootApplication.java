package com.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.platform.dao")
@ServletComponentScan
public class PlatformBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformBootApplication.class, args);
    }
}
