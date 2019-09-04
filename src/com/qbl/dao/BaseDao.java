package com.qbl.dao;

import java.sql.Connection;

import com.qbl.util.DbUtil;

public class BaseDao {
	public Connection con = new DbUtil().getCon();
}
