package com.qbl.model;

public class StuClass {
	private int id;
	private String name;
	private String info;

	public StuClass() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "StuClass [id=" + id + ", name=" + name + ", info=" + info + "]";
	}
}
