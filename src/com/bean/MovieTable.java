package com.bean;

public class MovieTable {
	private Integer mid;
	private String  moviename;
	private float time;
	private  float score;
	private  String imagepath;
	private String saveimagepath;
	private String  director;
	private String performer;
	private String  source;
	private String keyword;
	
	
	public String getPerformer() {
		return performer;
	}
	public void setPerformer(String performer) {
		this.performer = performer;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getSaveimagepath() {
		return saveimagepath;
	}
	public void setSaveimagepath(String saveimagepath) {
		this.saveimagepath = saveimagepath;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
