package com.tedu.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.mapper.UserMapper;
import com.tedu.pojo.User;
import com.tedu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> find() {
		return userMapper.find();
	}

	@Override
	public User get(Integer id) {
		return userMapper.get(id);
	}

	@Override
	public void insert(String name, Date birthday, String address) {
		userMapper.insert(name, birthday, address);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public void delete(Integer id) {
		userMapper.delete(id);
	}

}
