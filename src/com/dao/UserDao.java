package com.dao;

import java.util.List;

import com.bean.Users;

public interface UserDao {
	//查找一个对象
	public List<Users> select(Users user);
	//插入一个对象
	public boolean  insert (Users users);

}
