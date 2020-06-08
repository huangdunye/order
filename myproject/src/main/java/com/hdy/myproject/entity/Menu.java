package com.hdy.myproject.entity;

import java.util.Date;

public class Menu {
	private Integer id;
	private String level;
	private String pid;
	private String menuname;
	private String  cameraid;
	private Date createtime;
	private Date edittime;


	
	public String getCameraid() {
		return cameraid;
	}
	public void setCameraid(String cameraid) {
		this.cameraid = cameraid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getEdittime() {
		return edittime;
	}
	public void setEdittime(Date edittime) {
		this.edittime = edittime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	
	

}
