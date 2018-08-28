package com.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication //创建web环境，创建上下文对象
public class RunApp extends SpringBootServletInitializer{
	//继承SpringBootServletInitializer覆盖基类的configure方法
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RunApp.class);
	}
	public static void main(String[] args) {
		//启动web服务，tomcat
		SpringApplication.run(RunApp.class, args);
	}
}
