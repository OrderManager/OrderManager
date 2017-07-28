package com.orderManagement.command;

import java.util.HashMap;
import java.util.Map;

import com.orderManagement.main.OrderManagementMain;
import com.orderManagement.pojo.User;

public class UserCommandFactory extends SystemCommandFactory{

	private User user;

	public UserCommandFactory(User user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}
	
	private static Map<CommandCode, Class<? extends Command>> commandMap = new HashMap<>();
	
	static{
		User user = OrderManagementMain.getInstance().getUserfile();
		if(user.getRuleid() == 1){
			
		}
	}
	
}
