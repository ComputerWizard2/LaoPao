package com.dao;

import java.util.List;

import com.bean.MovieDec;

public interface MovieDecDao {
	//�������еĵ�Ӱ
	public List<MovieDec> select(MovieDec movieDec);
	//����һ����Ӱ
	public boolean insert(MovieDec movieDec);
	
}
