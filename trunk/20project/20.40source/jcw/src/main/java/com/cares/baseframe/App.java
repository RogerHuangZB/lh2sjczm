package com.cares.baseframe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages="com.cares.baseframe")
@MapperScan(basePackages = "com.cares.baseframe.mapper")
public class App {   
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
