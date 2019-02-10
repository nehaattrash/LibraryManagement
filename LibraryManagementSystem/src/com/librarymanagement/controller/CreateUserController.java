package com.librarymanagement.controller;

import com.librarymanagement.beans.User;
import com.librarymanagement.dao.CreateUserDao;

public class CreateUserController {
	public boolean createUser(User user) {
		boolean isUserCreated = false;
		CreateUserDao userDao = new CreateUserDao();
		try {
			isUserCreated = userDao.insertUserInfoDatabase(user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			return isUserCreated;
		}
	}
	
}
