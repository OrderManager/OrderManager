package com.orderManagement.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class UpdateDao {

	public static int deleteGoods(int goodsid) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("update goods set is_delete=1 where id=?");
			stmt.setInt(1, goodsid);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.clean(conn, stmt, null);
		}

		return 0;
	}

	public static int deleteOrder(int orderid) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("update order set status=1 where id=?");
			stmt.setInt(1, orderid);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.clean(conn, stmt, null);
		}

		return 0;
	}

	public static int deleteShop(int shopid) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("update shop set is_open=0 where id=?");
			stmt.setInt(1, shopid);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.clean(conn, stmt, null);
		}

		return 0;
	}

	public static int setOrderid(int orderid) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("update order_cart set order_id=? where order_id=0");
			stmt.setInt(1, orderid);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.clean(conn, stmt, null);
		}

		return 0;
	}

}
