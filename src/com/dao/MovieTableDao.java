package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bean.MovieTable;

public interface MovieTableDao {
	/**
	 * 查找所有的电影
	 */
	
	public List<MovieTable> select(MovieTable movieTable);
	
	/**
	 * delete 删除电影
	 */
	
	public boolean delete(@Param("mid") Integer mid);
	/**
	 * 新增一部电影
	 */
	public boolean insert (MovieTable movieTable);
	/**
	 * 更新电影的信息
	 */
	public boolean update(MovieTable movieTable);
	
}
