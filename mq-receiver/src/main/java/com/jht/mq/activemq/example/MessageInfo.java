package com.jht.mq.activemq.example;

import java.io.Serializable;

public class MessageInfo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2004045604647524786L;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	private String info;
	
	private String header;

}
