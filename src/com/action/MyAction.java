package com.action;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.bean.MovieTable;
import com.bean.Users;
import com.dao.MovieTableDao;
import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.tracing.dtrace.ProviderAttributes;
import com.util.MyBitsUtil;

public class MyAction extends ActionSupport implements SessionAware{
	
		private Users users ;
		private Map<String, Object> map;
		private static SqlSession session=MyBitsUtil.getSqlSession();
		private UserDao mapper = session.getMapper(UserDao.class);
		private MovieTableDao movie =  session.getMapper(MovieTableDao.class);
		private List<MovieTable> list;
		/**
		 * 仅用于登录的校验
		 * @return
		 */
		public String login ()
		{
		
			//获取request对象
			List<Users> select = mapper.select(users);
			if (select.size()>0&& select !=null) {
				map.put("users", select.get(0));
				//查找一下当前的电影
				
				return "chaxun";
			}
			return "error";
		}
		/**
		 * 用于查询电影的
		 * @return
		 */
		public String chaxun()
		{
			list = movie.select(null);
			return "success";
		}
		/**
		 * 仅用于注册的实现
		 * @return
		 */
		public String registe()
		{
			boolean insert = mapper.insert(users);
			if (insert) {
				
				return "success";
			}
			return "error";
		}
		/**
		 * 用于数据的判断是否合法
		 */
		@Override
		public void validate() {
			/**
			 * 先获取action名
			 */
			String actionName = ActionContext.getContext().getActionInvocation().getProxy().getActionName();
			if (actionName.equals("registedo")) {
				if (users.getUsername()==null||users.getUsername().length()==0) {
					//最关键的就是这个方法的使用，用作这个的数据提示的回显
					addFieldError("users.username", "姓名不能为空。。");
				}
				if (users.getPassword()==null||users.getPassword().length()==0) {
					addFieldError("users.password", "密码不能为空。。");
				}
			}
			
			
		}
		/**
		 * 仅用于跳转到注册的页面
		 * @return
		 */
		public String register()
		{
			return "register";
		}

		public Users getUsers() {
			return users;
		}

		public void setUsers(Users users) {
			this.users = users;
		}
		@Override
		public void setSession(Map<String, Object> arg0) {
			this.map=arg0;
		}
		public Map<String, Object> getMap() {
			return map;
		}
		public void setMap(Map<String, Object> map) {
			this.map = map;
		}
		public static SqlSession getSession() {
			return session;
		}
		public static void setSession(SqlSession session) {
			MyAction.session = session;
		}
		public UserDao getMapper() {
			return mapper;
		}
		public void setMapper(UserDao mapper) {
			this.mapper = mapper;
		}
		public MovieTableDao getMovie() {
			return movie;
		}
		public void setMovie(MovieTableDao movie) {
			this.movie = movie;
		}
		public List<MovieTable> getList() {
			return list;
		}
		public void setList(List<MovieTable> list) {
			this.list = list;
		}
	
	
}
