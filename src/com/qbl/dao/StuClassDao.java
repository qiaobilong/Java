package com.qbl.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qbl.model.StuClass;

public class StuClassDao extends BaseDao {
	public boolean addStuClass(StuClass cls) throws SQLException {
		String sql = "insert into s_class(id,name,info) values(null,?,?)";
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, cls.getName());
			prepareStatement.setString(2, cls.getInfo());
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
