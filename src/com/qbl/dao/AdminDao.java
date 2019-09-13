package com.qbl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.PresentationDirection;

import com.qbl.model.Admin;

public class AdminDao extends BaseDao {
	public Admin login(Admin admin) throws SQLException {// ��¼
		String sql = "select * from s_admin t where t.name = ? and t.password = ?";
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if (executeQuery.next()) {
				adminRst = new Admin();
				adminRst.setId(executeQuery.getInt("id"));
				adminRst.setName(executeQuery.getString("name"));
				adminRst.setPassword(executeQuery.getString("password"));
				adminRst.setCreateDate(executeQuery.getString("createdate"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return adminRst;
	}

	public String editPassword(Admin admin, String newPassword) throws SQLException {
		String reString = "";
		int id = -1;

		// �ж�ԭ���������Ƿ���ȷ
		String sql = "select * from s_admin t where t.name = ? and t.password = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if (!executeQuery.next()) {
				reString = "ԭ�������";
				return reString;
			}
			id = executeQuery.getInt("id");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ִ�и����߼�
		sql = "update s_admin t set t.password = ? where t.id = ?";
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, newPassword);
			prepareStatement.setInt(2, id);
			int executeUpdate = prepareStatement.executeUpdate();
			if (executeUpdate > 0) {
				reString = "�����޸ĳɹ�";
				return reString;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		reString = "�޸�ʧ��";
		return reString;
	}
}
