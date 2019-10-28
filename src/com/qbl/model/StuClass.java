package com.qbl.model;

public class StuClass {
	private int id;
	private String name;
	private String info;
	private Student students [];

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

	public Student[] getStudents() {
		return students;
	}

	public void setStudentid(Student[] students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return name;
	}
}
