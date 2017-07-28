package com.orderManagement.command.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.orderManagement.command.SystemCommand;
import com.orderManagement.dao.InsertDao;
import com.orderManagement.dao.SelectDao;
import com.orderManagement.utils.InputConsole;

public class SignupCommand extends SystemCommand {

	@Override
	public void execute() {

		InputConsole.println("The following is the rulemessage");

		ResultSet selectRulemsg = SelectDao.selectRulemsg();
		try {
			while (selectRulemsg.next()) {
				InputConsole.println(selectRulemsg.getInt(1) + " " + selectRulemsg.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true) {
			String username = InputConsole.askUserInput("Please enter your username��");
			String password = InputConsole.askUserInput("Please enter your password��");
			String phone = InputConsole.askUserInput("Please enter your phone��");
			String address = InputConsole.askUserInput("Please enter your address��");
			double money = Double.valueOf(InputConsole.askUserInput("Please enter your money��"));
			int ruleid = Integer.valueOf(InputConsole.askUserInput("Please enter your ruleid��"));

			boolean havingUser = SelectDao.isHavingUser(username);
			if (havingUser == false) {
				InsertDao.signup(username, password, phone, address, money, ruleid);
				InputConsole.println("Signup Successfully");
				break;
			} else {
				InputConsole.println("There is alread a same username here,please enter again");
				continue;
			}
		}

	}

}
