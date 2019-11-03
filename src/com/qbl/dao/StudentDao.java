package com.qbl.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qbl.model.Student;
import com.qbl.util.StringUtil;

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

	public List<Student> getStudentList(Student student) throws SQLException {
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sql = new StringBuffer("select * from s_student where 1 = 1 ");
		if (!StringUtil.isEmpty(student.getName())) {
			sql.append("and name = '" + student.getName() + "' ");
		}
		if (student.getStuclassid() != 0) {
			sql.append("and classId = " + student.getStuclassid() + " ");
		}
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql.toString());
			ResultSet executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
				Student s = new Student();
				s.setId(executeQuery.getInt("id"));
				s.setName(executeQuery.getString("name"));
				s.setPassword(executeQuery.getString("password"));
				s.setSex(executeQuery.getString("sex"));
				s.setStuclassid(executeQuery.getInt("classId"));
				retList.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retList;
	}
}
