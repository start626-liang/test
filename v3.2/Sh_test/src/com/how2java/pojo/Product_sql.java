package com.how2java.pojo;


public class Product_sql {

	private int id;
	private String name;
	private String content;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getDate(){
		return date;
	}
}
