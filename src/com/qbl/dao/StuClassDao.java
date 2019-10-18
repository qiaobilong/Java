package com.qbl.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qbl.model.StuClass;
import com.qbl.util.StringUtil;

public class StuClassDao<Stuclass> extends BaseDao {
	public boolean addStuClass(StuClass stuClass) throws SQLException {
		String sql = "insert into s_class(id,name,info) values(null,?,?)";
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, stuClass.getName());
			prepareStatement.setString(2, stuClass.getInfo());
			if (prepareStatement.executeUpdate() > 0) {// 返回的是int，表示有多少条数据受到了影响
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public List<Stuclass> getClassList(StuClass stuClass) throws SQLException {
		List<Stuclass> retList = new ArrayList<Stuclass>();
		String sql = "select * from s_class";
		if (!StringUtil.isEmpty(stuClass.getName())) {
			sql += " where name like '%" + stuClass.getName() + "%'";
		}
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			ResultSet executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
				StuClass sc = new StuClass();
				sc.setId(executeQuery.getInt("id"));
				sc.setName(executeQuery.getString("name"));
				sc.setInfo(executeQuery.getString("info"));
				retList.add((Stuclass) sc);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retList;
	}

	public boolean delete(int id) {
		String sql = "delete from s_class where id = ?";
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
