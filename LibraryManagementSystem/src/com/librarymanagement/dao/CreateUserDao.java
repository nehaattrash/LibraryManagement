package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.librarymanagement.beans.JdbcConstants;
import com.librarymanagement.beans.User;

public class CreateUserDao {
	public boolean insertUserInfoDatabase(User user) throws ClassNotFoundException{
		boolean isInserted = true;
		System.out.println(user.toString());
		Class.forName(JdbcConstants.driverName);
		try(
				Connection con = DriverManager.getConnection(JdbcConstants.jdbcUrl,JdbcConstants.userId,JdbcConstants.userPassword);
			) {
			String query = "insert into User values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1,user.getName());
			preparedStmt.setString(2,user.getRollno());
			preparedStmt.setString(3,user.getMobileno());
			preparedStmt.setString(4,user.getBloodGroup());
			preparedStmt.setString(5, user.getdOB());
			preparedStmt.setString(6,user.getBranch());
			preparedStmt.setString(7,user.getSession());
			preparedStmt.setString(8,user.getSex());
			preparedStmt.setString(9,user.getRole());
			preparedStmt.setString(10, user.getPassword());
			preparedStmt.setString(11,user.getConfirmPassword());
			preparedStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			isInserted = false;
		}  finally {
			return isInserted;
		}  
	}
}
