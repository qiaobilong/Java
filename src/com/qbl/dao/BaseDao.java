package com.qbl.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.qbl.util.DbUtil;

public class BaseDao {
	public Connection con = new DbUtil().getConnection("mysql");
	public void closeDao() {
		try {
			con.close();
			System.out.println("数据库连接已关闭！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
