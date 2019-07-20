package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.example.demo.dao") // 添加dao的扫描
public class DemoApplication {

	public static void main(String[] args) {
		// 携带logo
		//SpringApplication.run(DemoApplication.class, args);
		
		// 关闭logo 
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);
	}
}
