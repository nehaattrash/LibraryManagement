package com.librarymanagement.beans;

public class UserCredential {
	
	private String name;
	private String role;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "UserCredential [name=" + name + ", role=" + role + ", password=" + password + "]";
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
