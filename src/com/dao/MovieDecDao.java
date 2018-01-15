package com.dao;

import java.util.List;

import com.bean.MovieDec;

public interface MovieDecDao {
	//查找所有的电影
	public List<MovieDec> select(MovieDec movieDec);
	//插入一个电影
	public boolean insert(MovieDec movieDec);
	
}
