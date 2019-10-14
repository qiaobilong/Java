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
		String dbUrlOralce = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";// ���ݿ����ӵ�ַ
		String jdbcNameOralce = "oracle.jdbc.OracleDriver";// ������

		// MySQL
		String dbUrlMySQL = "jdbc:mysql://127.0.0.1:3306/db_student?useSSL=true&useUnicode=true&characterEncoding=utf8";// ���ݿ����ӵ�ַ
		String jdbcNameMySQL = "com.mysql.jdbc.Driver";// ������

		// ����Ĭ�����ݿ�
		if ("".equals(database) || database == null) {
			database = "mysql";
		}

		// ����database�������Ӳ���
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
			System.out.println("�ݲ�֧�ִ����ݿ⣨" + database + "��������");
		}

		// ע������
		try {
			Class.forName(jdbcName);
			System.out.println("����" + database + "�����ɹ���");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("����" + database + "����ʧ�ܣ�");
		}

		// ��ȡ����
		try {
			con = DriverManager.getConnection(dbUrl, user, password);
			System.out.println("�������ݿ�ɹ���");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�");
		}

		// ����һ�����ݿ�����
		return con;
	}
}
