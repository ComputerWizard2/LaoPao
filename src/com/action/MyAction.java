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
		 * �����ڵ�¼��У��
		 * @return
		 */
		public String login ()
		{
		
			//��ȡrequest����
			List<Users> select = mapper.select(users);
			if (select.size()>0&& select !=null) {
				map.put("users", select.get(0));
				//����һ�µ�ǰ�ĵ�Ӱ
				
				return "chaxun";
			}
			return "error";
		}
		/**
		 * ���ڲ�ѯ��Ӱ��
		 * @return
		 */
		public String chaxun()
		{
			list = movie.select(null);
			return "success";
		}
		/**
		 * ������ע���ʵ��
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
		 * �������ݵ��ж��Ƿ�Ϸ�
		 */
		@Override
		public void validate() {
			/**
			 * �Ȼ�ȡaction��
			 */
			String actionName = ActionContext.getContext().getActionInvocation().getProxy().getActionName();
			if (actionName.equals("registedo")) {
				if (users.getUsername()==null||users.getUsername().length()==0) {
					//��ؼ��ľ������������ʹ�ã����������������ʾ�Ļ���
					addFieldError("users.username", "��������Ϊ�ա���");
				}
				if (users.getPassword()==null||users.getPassword().length()==0) {
					addFieldError("users.password", "���벻��Ϊ�ա���");
				}
			}
			
			
		}
		/**
		 * ��������ת��ע���ҳ��
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
