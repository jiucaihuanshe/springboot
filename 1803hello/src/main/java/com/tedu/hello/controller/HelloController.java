package com.tedu.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * http://localhost:8080/hello
 * @author wangchaofan
 *
 */
@RestController //标识这个类是以Controller，返回强制json
public class HelloController {
	@RequestMapping("/hello")
	public String hello(){
		return "hello springBoot!";
	}
}
