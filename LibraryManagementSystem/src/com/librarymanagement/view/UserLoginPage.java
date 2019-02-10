package com.librarymanagement.view;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.librarymanagement.base.BasePage;
import com.librarymanagement.beans.UserCredential;
import com.librarymanagement.controller.UserLoginController;
import com.librarymanagement.dao.UserLoginDao;
import com.librarymanagement.utility.ScreenSizeUtility;
public class UserLoginPage implements ActionListener,BasePage{
	Container c;
	JFrame userLoginPageFrame ;
	JLabel userId ;
	JLabel userPassword ;
	JLabel userRole;
	JTextField userIdTextField;
	JPasswordField userPasswordTextField;
	JComboBox userRoleComboBox ;
	JButton loginButton;
	JButton forgotPasswordButton;
	JButton createNewUserButton;
	JTextField roleTextField ;
	public void setComponentBounds() {
		userLoginPageFrame.setBounds(0,0,ScreenSizeUtility.getMaxWidth(),ScreenSizeUtility.getMaxHeight());
		userId.setBounds(100,100,300,30);
		userPassword.setBounds(100,200,300,30);
		userRole.setBounds(100,300,300,30);
		userIdTextField.setBounds(500,100,300,30);
		userPasswordTextField.setBounds(500,200,300,30);
		userRoleComboBox.setBounds(500,300,300,30);
		loginButton.setBounds(400,400,300,30);
		forgotPasswordButton.setBounds(100,400,200,30);
		createNewUserButton.setBounds(700,400,300,30);
	}
	public void addToContainer(){
		c.add(userId);
		c.add(userPassword);
		c.add(userRole);
		c.add(userIdTextField);
		c.add(userPasswordTextField);
		c.add(userRoleComboBox);
		c.add(loginButton);
		c.add(forgotPasswordButton);
		c.add(createNewUserButton);
	}
	public void setComponentText(){
		userId.setText("USER ID");
		userPassword.setText("PASSWORD");
		userRole.setText("ROLE");
	}
	public void setComponentFont(){
		Font font = new Font("Arial",Font.BOLD,30);
		userId.setFont(font);
		userPassword.setFont(font);
		userRole.setFont(font);
	}
	public  void createLoginFrame(){
		userLoginPageFrame = new JFrame();
		userLoginPageFrame.setVisible(true);
		userLoginPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userLoginPageFrame.setTitle("Login Page");
		c = userLoginPageFrame.getContentPane();
		userId = new JLabel();
		userPassword = new JLabel();
		userRole = new JLabel();
		c.setLayout(null);
		userIdTextField = new JTextField();
		userPasswordTextField = new JPasswordField();
		roleTextField = new JTextField();
		loginButton = new JButton("Login");
		String[] roles = {"Student","Admin"};
		userRoleComboBox = new JComboBox(roles);
		forgotPasswordButton = new JButton("Forgot Password");
		createNewUserButton = new JButton("Create New User");
		setComponentBounds();
		setComponentText();
		setComponentFont();
		loginButton.addActionListener(this);
		createNewUserButton.addActionListener(this);
		forgotPasswordButton.addActionListener(this);
		addToContainer();
	}
	public void actionPerformed(ActionEvent e){
		UserLoginController userLoginController = new UserLoginController();
		CreateUserPage createUser = new CreateUserPage();
		ForgotPasswordPage forgotPassword = new ForgotPasswordPage();
		if(e.getSource() == loginButton) {
			UserCredential user = getUserCredential();
			userLoginController.validateUser(user);
		}else if(e.getSource() == createNewUserButton) {
				createUser.createNewUserFrame();
				userLoginPageFrame.dispose();
		}else if(e.getSource() == forgotPasswordButton) {
			forgotPassword.createForgotPasswordFrame();
			userLoginPageFrame.dispose();
		}
	}
	public UserCredential getUserCredential() {
		UserCredential userCredential = new UserCredential();
		userCredential.setName(userIdTextField.getText());
		userCredential.setPassword(userPasswordTextField.getText());
		userCredential.setRole((String)userRoleComboBox.getItemAt(userRoleComboBox.getSelectedIndex()));
		return  userCredential;
	}
	public static void main(String[] args){
		UserLoginPage userLoginPage = new UserLoginPage();
		userLoginPage.createLoginFrame();
	}
}
