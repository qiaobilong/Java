package com.qbl.model;

public class Student {
	private int id;
	private String name;
	private String password;
	private String sex;
	private StuClass stuclass;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String password, String sex, StuClass stuclass) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.stuclass = stuclass;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public StuClass getStuclass() {
		return stuclass;
	}

	public void setStuclass(StuClass stuclass) {
		this.stuclass = stuclass;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", stuclass="
				+ stuclass + "]";
	}

}
