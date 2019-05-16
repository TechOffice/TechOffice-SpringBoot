package com.techoffice.http.model;

public class ResponseData {

	private String data;
	
	public ResponseData(String data){
		this.data = data;
	}
	
	public void setDate(String data){
		this.data = data;
	}
	
	public String getData(){
		return this.data;
	}
}
