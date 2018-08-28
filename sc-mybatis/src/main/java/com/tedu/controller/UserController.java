package com.tedu.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.pojo.User;
import com.tedu.pojo.UserVO;
import com.tedu.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/find")
	public List<User> find(){
		return userService.find();
	}
	//采用restful，springboot它@PathVariable必须写后面变量
	@RequestMapping("/get/{id}")
	public User get(@PathVariable("id") Integer id){
		return userService.get(id);
	}
	@RequestMapping("/insert/{name}/{birthday}/{address}")
	public String insert(@PathVariable("name")String name,@PathVariable("birthday")String birthday,@PathVariable("address")String address){
		try {
			//日期转换
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday2 = format.parse(birthday);
			System.out.println(birthday2);
			userService.insert(name,birthday2,address);
			return "success";
		} catch (Exception e) {
			return "insert error";
		}
	}
	@RequestMapping("/update/{name}/{birthday}/{address}/{id}")
	public String update(UserVO u){
		try {
			User user = new User();
			user.setId(u.getId());
			user.setName(u.getName());
			user.setAddress(u.getAddress());
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday2 = format.parse(u.getBirthday());
			user.setBirthday(birthday2);
			userService.update(user);
			return "success";
		} catch (Exception e) {
			return "update error";
		}
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")Integer id){
		try {
			userService.delete(id);
			return "success";
		} catch (Exception e) {
			return "delete error";
		}
	}
}
