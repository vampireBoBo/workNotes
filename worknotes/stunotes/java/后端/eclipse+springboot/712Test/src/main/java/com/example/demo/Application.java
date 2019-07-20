package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages="com.example.demo")
@MapperScan(basePackages="com.example.demo.dao")
public class Application {

	public static void main(String[] args) {
		// 携带logo
		//SpringApplication.run(DemoApplication.class, args);
		
		// 关闭logo 
		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);
	}
}
