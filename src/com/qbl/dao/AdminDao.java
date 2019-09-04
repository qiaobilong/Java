package com.qbl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qbl.model.Admin;

public class AdminDao extends BaseDao {
	public Admin login(Admin admin) throws SQLException {
		String sql = "select * from s_admin t where t.name = ? and t.password = ?";
		
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet rst = prst.executeQuery();
			if (rst.next()) {
				adminRst = new Admin();
				adminRst.setId(rst.getInt("id"));
				adminRst.setName(rst.getString("name"));
				adminRst.setPassword(rst.getString("password"));
				adminRst.setCreateDate(rst.getString("createdate"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return adminRst;
	}
}
