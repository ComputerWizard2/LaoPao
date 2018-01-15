package com.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * myBatits工具类
 * 用来获取SqlSession
 * 
 * @author Administrator
 *
 */
public class MyBitsUtil {
	/**
	 * 1. 构建SqlSessionFactory 
	 * @throws IOException 
	 * 
	 */
	private static SqlSessionFactory getSqlSessionFactory() throws IOException
	{
		//1. 定义主配置文件的存放位置,因为我们将配置文件放在了SRC下，所有直接写文件你的名字
		String resource="mybits-config.xml";
		//2. 读取输入流，读取配置文件
		InputStream inputStream =Resources.getResourceAsStream(resource);
		//3. 实例化sqlsessionFactoryBuilder 
	
		SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
		//4. 通过调用builder的build 方法根据配置文件创建出SQLsessionFactory
		SqlSessionFactory sessionFactory =builder.build(inputStream);
		return sessionFactory;
		
		
	}
	
	
	
	
	/**
	 * 2. 获取sqlSession对象
	 */
	public static SqlSession getSqlSession(){
		
		SqlSession sqlSession=null;
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
		
		
		
		
	}
	
	
	

}
