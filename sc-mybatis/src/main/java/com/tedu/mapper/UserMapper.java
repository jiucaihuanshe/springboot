package com.tedu.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tedu.pojo.User;

//注解和xml方式混合
public interface UserMapper {
	//调用xml方式
	public List<User> find();
	//调用注解方式 参数pojo @Param()
	@Select("select * from user where id=#{id}")
	public User get(@Param("id")Integer id);
	//新增用户
	@Insert("insert into user(name,birthday,address) values(#{name},#{birthday},#{address})")
	public void insert(@Param("name")String name,@Param("birthday")Date birthday,@Param("address")String address);
	//修改用户
	@Update("update user set name=#{name},birthday=#{birthday},address=#{address} where id=#{id}")
	public void update(User user);
	//删除用户
	@Delete("delete from user where id=#{id}")
	public void delete(@Param("id")Integer id);
}
