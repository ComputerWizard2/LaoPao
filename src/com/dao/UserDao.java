package com.dao;

import java.util.List;

import com.bean.Users;

public interface UserDao {
	//����һ������
	public List<Users> select(Users user);
	//����һ������
	public boolean  insert (Users users);

}
