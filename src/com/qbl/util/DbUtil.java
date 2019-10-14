package com.qbl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private Connection con = null;
	private String dbUrl = null;
	private String jdbcName = null;
	private String user = null;
	private String password = null;

	public Connection getConnection(String database) {
		// Oracle
		String dbUrlOralce = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";// 数据库连接地址
		String jdbcNameOralce = "oracle.jdbc.OracleDriver";// 驱动名

		// MySQL
		String dbUrlMySQL = "jdbc:mysql://127.0.0.1:3306/db_student?useSSL=true&useUnicode=true&characterEncoding=utf8";// 数据库连接地址
		String jdbcNameMySQL = "com.mysql.jdbc.Driver";// 驱动名

		// 配置默认数据库
		if ("".equals(database) || database == null) {
			database = "mysql";
		}

		// 根据database配置连接参数
		if ("oracle".equals(database.toLowerCase())) {
			dbUrl = dbUrlOralce;
			jdbcName = jdbcNameOralce;
			user = "scott";
			password = "tiger";
		} else if ("mysql".equals(database.toLowerCase())) {
			dbUrl = dbUrlMySQL;
			jdbcName = jdbcNameMySQL;
			user = "root";
			password = "root";
		} else {
			System.out.println("暂不支持此数据库（" + database + "）的连接");
		}

		// 注册驱动
		try {
			Class.forName(jdbcName);
			System.out.println("加载" + database + "驱动成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载" + database + "驱动失败！");
		}

		// 获取连接
		try {
			con = DriverManager.getConnection(dbUrl, user, password);
			System.out.println("连接数据库成功！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接数据库失败！");
		}

		// 返回一个数据库连接
		return con;
	}
}
