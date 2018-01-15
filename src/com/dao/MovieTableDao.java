package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bean.MovieTable;

public interface MovieTableDao {
	/**
	 * �������еĵ�Ӱ
	 */
	
	public List<MovieTable> select(MovieTable movieTable);
	
	/**
	 * delete ɾ����Ӱ
	 */
	
	public boolean delete(@Param("mid") Integer mid);
	/**
	 * ����һ����Ӱ
	 */
	public boolean insert (MovieTable movieTable);
	/**
	 * ���µ�Ӱ����Ϣ
	 */
	public boolean update(MovieTable movieTable);
	
}
