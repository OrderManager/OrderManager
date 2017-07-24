package com.orderManagement.command;

import com.orderManagement.pojo.User;

public abstract class BuyerCommand implements Command {

	protected User userProFile;

	public BuyerCommand(User userProFile) {
		this.userProFile = userProFile;
	}

}
