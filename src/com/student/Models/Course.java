package com.student.Models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean@RequestScoped

public class Course {
	
	private String cid;
	private String cname;
	private int duration;

	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(String id, String name, int duration) {
		this.cid = id;
		this.cname = name;
		this.duration = duration;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
