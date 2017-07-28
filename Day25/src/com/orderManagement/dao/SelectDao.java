package com.orderManagement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDao {

	public static ResultSet login(String name, String password) {
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
		}

		return null;
	}

	public static boolean isHavingUser(String username) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("select * from user where name=?");
			stmt.setString(1, username);

			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString(2) != null) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static ResultSet selectRulemsg() {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("select * from rule");

			rs = stmt.executeQuery();
			if (rs != null) {
				return rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static ResultSet selectGoods() {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("select * from goods where is_delete=0");

			rs = stmt.executeQuery();
			if (rs != null) {
				return rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static ResultSet selectGoodsByShopid(int userid) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement(
					"select * from goods where is_delete=0 and shop_id in (select id from shop where user_id=?)");
			stmt.setInt(1, userid);

			rs = stmt.executeQuery();
			if (rs != null) {
				return rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static ResultSet selectOrdercart(int userid) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("select * from order_cart where user_id=?");
			stmt.setInt(1, userid);

			rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					return rs;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static ResultSet selectOrderid(int userid) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("select id from order where user_id=?");
			stmt.setInt(1, userid);

			rs = stmt.executeQuery();
			if (rs != null) {
				return rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static ResultSet selectShop(int userid) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("select * from shop where user_id=?");
			stmt.setInt(1, userid);

			rs = stmt.executeQuery();
			if (rs != null) {
				return rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static double selectGoodsPrice(int goodsid, int userid) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("select price from goods,order_cart where 	"
					+ "goods.id=order_cart.goods_id and order_cart.goods_id=? and user_id=?");
			stmt.setInt(1, goodsid);
			stmt.setInt(2, userid);

			rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					return rs.getDouble(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
