package com.github.sugarmgp.demoproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author SugarMGP
 */
@SpringBootApplication
@MapperScan("com.github.sugarmgp.demoproject.mapper")
public class DemoProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }
}
