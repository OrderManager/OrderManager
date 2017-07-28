package com.orderManagement.command.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.orderManagement.command.SystemCommand;
import com.orderManagement.dao.SelectDao;
import com.orderManagement.main.OrderManagementMain;
import com.orderManagement.pojo.User;
import com.orderManagement.utils.InputConsole;

public class LoginCommand extends SystemCommand {

	@Override
	public void execute() {

		OrderManagementMain omm = OrderManagementMain.getInstance();

		String username = InputConsole.askUserInput("Please enter your username£º");
		String password = InputConsole.askUserInput("Please enter your password£º");

		ResultSet rs = SelectDao.login(username, password);
		if (rs != null) {
			try {
				while (rs.next()) {
					User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getDouble(6), rs.getInt(7));
					omm.setUserfile(user);
					InputConsole.println("Login Successfully");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			InputConsole.println("Your username or password is false");
		}

	}

}
