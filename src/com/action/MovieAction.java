package com.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.websocket.Session;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.bean.MovieDec;
import com.bean.MovieTable;
import com.dao.MovieDecDao;
import com.dao.MovieTableDao;
import com.opensymphony.xwork2.ActionSupport;
import com.util.MyBitsUtil;

public class MovieAction extends ActionSupport{
	private SqlSession session =MyBitsUtil.getSqlSession();
	private MovieTable movieTable;
	private MovieDec movieDec;
	 private MovieTableDao mapper = session.getMapper(MovieTableDao.class);
	 private MovieDecDao map =session.getMapper(MovieDecDao.class);
	 
	 private Integer mid;
	 //�ϴ����ļ���
	 
	 private File fileupload ;
	 private String fileuploadFileName;
	 private String fileuploadContentType;
	 private List<MovieDec> select;
	public String delete()
	{
		boolean delete = mapper.delete(mid);
		if (delete) {
			
			return "chaxun";
		}
		return "error";
		
	}

	/**
	 * �����ڴ���ҳ��
	 * @return
	 */
	public String insert()
	{
		
		return "insert";
	}
	/**
	 * ���յ������ݲ��뵽���ݿ�
	 * @return
	 * @throws IOException 
	 */
	public String doinsert() 
	{
		//��ȡͼƬ�Ĵ洢����ʵ��·��
		String realPath = ServletActionContext.getRequest().getServletContext().getRealPath("/upload");
		//��ȡ���·��
		String viewPath = ServletActionContext.getRequest().getContextPath()+"/upload/"+fileuploadFileName;
		//�ϴ��ļ�
		try {
			FileUtils.copyFile(fileupload, new File(realPath, fileuploadFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//��·���������ݿ���
		movieTable.setImagepath(viewPath);
		movieTable.setSaveimagepath(realPath);
		boolean insert = mapper.insert(movieTable);
			return "chaxun";
	}
	/**
	 * ��ת��������ҳ
	 * @return
	 */
	public String selfpage(){
		movieTable=new MovieTable();
		movieTable.setMid(mid);
		movieTable= mapper.select(movieTable).get(0);
		movieDec =new  MovieDec();
		movieDec.setMid(mid);
		select= map.select(movieDec);
		return "movie";
	}
	/**
	 * ���������۲��Ҹ�������
	 * @return
	 */
	public String  updateDesc(){
		System.out.println("update");
		System.out.println(movieDec.getScore());
		movieDec.getScore();
		movieTable.getMid();
//		movieDec.setMid(movieTable.getMid());
//		boolean insert = map.insert(movieDec);
//		List<MovieDec> select2 = map.select(movieDec);
//		/*
//		 * ��ƽ����
//		 */
//		int sum =0;
//		float avg=0;
//		for (MovieDec movieDec : select2) {
//			sum+=movieDec.getScore();
//		}
//		avg=sum/select2.size();
//			
//			movieTable.setMid(movieDec.getMid());
//			movieTable.setScore(avg);
//			boolean update = mapper.update(movieTable);
			
	
		return "self";
	}
	
	public MovieDec getMovieDec() {
		return movieDec;
	}

	public void setMovieDec(MovieDec movieDec) {
		this.movieDec = movieDec;
	}

	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public MovieTable getMovieTable() {
		return movieTable;
	}
	public void setMovieTable(MovieTable movieTable) {
		this.movieTable = movieTable;
	}
	public File getFileload() {
		return fileupload;
	}
	public void setFileload(File fileload) {
		this.fileupload = fileload;
	}
	public String getFileuploadFileName() {
		return fileuploadFileName;
	}
	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}
	public String getFileuploadContentType() {
		return fileuploadContentType;
	}
	public void setFileuploadContentType(String fileuploadContentType) {
		this.fileuploadContentType = fileuploadContentType;
	}
	public File getFileupload() {
		return fileupload;
	}
	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}
	public List<MovieDec> getSelect() {
		return select;
	}
	public void setSelect(List<MovieDec> select) {
		this.select = select;
	}
	
	
}
