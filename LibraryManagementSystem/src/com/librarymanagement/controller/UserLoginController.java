package com.librarymanagement.controller;

import com.librarymanagement.beans.UserCredential;
import com.librarymanagement.dao.UserLoginDao;
import com.librarymanagement.view.AlertBox;

public class UserLoginController {
	public void validateUser(UserCredential user){
		boolean isValidUser = false;
		try {
			isValidUser = UserLoginDao.isAuthenticatedUser(user);
			if(isValidUser){
				AlertBox.showInfo("Valid User!!!");
			}else{
				AlertBox.showInfo(" InValid User!!!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
