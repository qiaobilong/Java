package com.qbl.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qbl.model.Student;

public class StudentDao extends BaseDao {
	public boolean insert(Student student) {
		String sql = "insert into s_student(id,name,classid,password,sex) values(null,?,?,?,?)";
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, student.getName());
			prepareStatement.setInt(2, student.getStuclassid());
			prepareStatement.setString(3, student.getPassword());
			prepareStatement.setString(4, student.getSex());
			if (prepareStatement.executeUpdate() > 0) {// 返回的是int，表示有多少条数据受到了影响
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Student student) {
		String sql = "update s_student set name = ?, password = ?, sex = ?, classid = ? where id = ?";
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, student.getName());
			prepareStatement.setString(2, student.getPassword());
			prepareStatement.setString(3, student.getSex());
			prepareStatement.setInt(4, student.getStuclassid());
			prepareStatement.setInt(5, student.getId());
			if (prepareStatement.executeUpdate() > 0) {// 返回的是int，表示有多少条数据受到了影响
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "delete from s_student where id = ?";
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			if (prepareStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
