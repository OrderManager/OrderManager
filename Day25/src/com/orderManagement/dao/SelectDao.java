package com.orderManagement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDao {

	public static ResultSet selectUser(String name, String password) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("select * from user where name=? and password=?");
			stmt.setString(1, name);
			stmt.setString(2, password);

			rs = stmt.executeQuery();
			if (rs != null) {
				return rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.clean(conn, stmt, rs);
		}

		return null;
	}

	public static ResultSet selectGoods() {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("select * from goods");

			rs = stmt.executeQuery();
			if (rs != null) {
				return rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.clean(conn, stmt, rs);
		}

		return null;
	}

}
