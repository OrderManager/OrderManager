package com.orderManagement.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteDao {

	public static int deleteOrderCart(int userid) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;

		try {
			conn = MyConnection.getConnection();
			stmt = conn.prepareStatement("delete from order_cart where user_id=?");
			stmt.setInt(1, userid);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
