package com.gis.springboot.springboot;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
public class Man {

	private String from;
	private String to;
	private int age;
	public Man() {
		super();
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Man(String from, String to, int age) {
		super();
		this.from = from;
		this.to = to;
		this.age = age;
	}

}
