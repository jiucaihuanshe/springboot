package com.tedu.service;

import java.util.Date;
import java.util.List;

import com.tedu.pojo.User;

public interface UserService {
	public List<User> find();
	public User get(Integer id);
	public void insert(String name, Date birthday, String address);
	public void update(User user);
	public void delete(Integer id);
}
