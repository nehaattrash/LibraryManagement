package com.librarymanagement.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.librarymanagement.beans.JdbcConstants;
import com.librarymanagement.beans.UserCredential;
public class UserLoginDao{ 
	public static boolean isAuthenticatedUser(UserCredential user) throws ClassNotFoundException{
		boolean isAuthenticated = false; 
		Class.forName(JdbcConstants.driverName); 
		try(   
			Connection connection = DriverManager.getConnection(JdbcConstants.jdbcUrl,JdbcConstants.userId,JdbcConstants.userPassword);
			){  
			Statement stmt = connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from  UserCredential");
			while(rs.next()){
				if(rs.getString("name").equals(user.getName()) && rs.getString("password").equals(user.getPassword())&& rs.getString("role").equals(user.getRole())){
					isAuthenticated = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			return isAuthenticated;
		}	
	}
}  
