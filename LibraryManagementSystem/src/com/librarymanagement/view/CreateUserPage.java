package com.librarymanagement.view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;

import com.librarymanagement.base.BasePage;
import com.librarymanagement.beans.User;
import com.librarymanagement.controller.CreateUserController;
import com.librarymanagement.utility.DateTimeUtility;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class CreateUserPage implements ActionListener,BasePage{
	private JFrame infoFrame;
	private JLabel name;
	private JLabel dOB;
    private JLabel bloodGroup;
    private	JLabel sex;
	private JLabel course;
	private JLabel branch;
	private JLabel session;
	private JLabel mobileno;
	private JLabel rollno;
	private JLabel role;
	private JLabel password;
	private JLabel confirmPassword;
	private JButton submitButton;
	private JButton resetButton;
	public  JTextField nameTextField ;
	public  JTextField dOBTextField;
    public  JTextField bloodGroupTextField;
	private JRadioButton sexRadioButton1;
	private JRadioButton sexRadioButton2;
	private JRadioButton sexRadioButton3;
	private JComboBox branchComboBox;
	private JComboBox sessionComboBox;
	public  JTextField mobilenoTextField;
	public  JTextField rollnoTextField;
	public JTextField roleTextField;
	public JTextField passwordTextField;
	public JTextField confirmPasswordTextField;
	Container c;
	public void setComponentBounds(){
		infoFrame.setBounds(100,100,800,800);
		name.setBounds(100,90,200,20);
		rollno.setBounds(100,120,200,20);
		dOB.setBounds(100,150,200,20);
		bloodGroup.setBounds(100,180,200,20);
		sex.setBounds(100,210,200,20);
		mobileno.setBounds(100,240,200,20);
		branch.setBounds(100,270,200,20);
		session.setBounds(100,300,200,20);
		role.setBounds(100,330,200,20);
		password.setBounds(100,360,200,20);
		confirmPassword.setBounds(100,390,200,20);
		nameTextField.setBounds(300,90,200,20);
		rollnoTextField.setBounds(300,120,200,20);
		dOBTextField.setBounds(300,150,200,20);
		bloodGroupTextField.setBounds(300,180,200,20);
		sexRadioButton1.setBounds(300,210,100,20);
		sexRadioButton2.setBounds(400,210,100,20);
		sexRadioButton3.setBounds(500,210,100,20);
		mobilenoTextField.setBounds(300,240,200,20);
		branchComboBox.setBounds(300,270,200,20);
		sessionComboBox.setBounds(300,300,200,20);
		roleTextField.setBounds(300,330,200,20);
		passwordTextField.setBounds(300,360,200,20);
		confirmPasswordTextField.setBounds(300,390,200,20);
		
		submitButton.setBounds(300,500,200,20);
		resetButton.setBounds(100,500,200,20);
	}
	public void addToContainer(){
		c.add(rollno);
		c.add(dOB);
		c.add(bloodGroup);
		c.add(sex);
		c.add(mobileno);
		c.add(branch);
		c.add(session);
		c.add(nameTextField);
		c.add(rollnoTextField);
		c.add(dOBTextField);
		c.add(bloodGroupTextField);
		c.add(sexRadioButton1);
		c.add(sexRadioButton2);
		c.add(sexRadioButton3);
		c.add(mobilenoTextField);
		c.add(branchComboBox);
		c.add(sessionComboBox);
		c.add(name);
		c.add(submitButton);
		c.add(resetButton);
		c.add(role);
		c.add(password);
		c.add(confirmPassword);
		c.add(roleTextField);
		c.add(passwordTextField);
		c.add(confirmPasswordTextField);
	}
	public void setComponentFont(){
		Font f = new Font("Arial",Font.PLAIN,20);
		name.setFont(f);
		rollno.setFont(f);
		dOB.setFont(f);
		bloodGroup.setFont(f);
		sex.setFont(f);
		mobileno.setFont(f);
		course.setFont(f);
		branch.setFont(f);
		session.setFont(f);
		nameTextField.setFont(f);
		rollnoTextField.setFont(f);
		dOBTextField.setFont(f);
		bloodGroupTextField.setFont(f);
		mobilenoTextField.setFont(f);
		submitButton.setFont(f);
		resetButton.setFont(f);
		role.setFont(f);
		password.setFont(f);
		confirmPassword.setFont(f);
		roleTextField.setFont(f);
		passwordTextField.setFont(f);
		confirmPasswordTextField.setFont(f);
	}
	public void setComponentText(){
		name.setText("Name");
		rollno.setText("RollNo");
		dOB.setText("DOB (dd/MM/yyyy)");
		bloodGroup.setText("BloodGroup");
		sex.setText("Sex");
		mobileno.setText("MobileNo");
		course.setText("Course");
		branch.setText("Branch");
		session.setText("Session");
		role.setText("Role");
		password.setText("Password");
		confirmPassword.setText("Confirm Password");
	}
	public  void createNewUserFrame(){
		Scanner sc = new Scanner(System.in);
		infoFrame = new JFrame();
		infoFrame.setVisible(true);
		infoFrame.setDefaultCloseOperation(infoFrame.EXIT_ON_CLOSE);
		infoFrame.setExtendedState(infoFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		name = new JLabel();
		rollno = new JLabel();
		dOB = new JLabel();
		bloodGroup = new JLabel();
		mobileno = new JLabel();
		sex = new JLabel();
		course = new JLabel();
		branch = new JLabel();
		session = new JLabel();
		role = new JLabel();
		password = new JLabel();
		confirmPassword = new JLabel();
		roleTextField = new JTextField();
		passwordTextField = new JTextField();
		confirmPasswordTextField = new JTextField();
		nameTextField = new JTextField();
		rollnoTextField = new JTextField();
		dOBTextField = new JTextField();
		bloodGroupTextField = new JTextField();
		mobilenoTextField = new JTextField();
		String[] branchName = {"CSE","ECE","MECH","EEE"};
		branchComboBox = new JComboBox(branchName);
		String[] sessions = {"2015-2019","2016-2020","2017-2021","2018-2022"};
		sessionComboBox = new JComboBox(sessions);
		submitButton = new JButton("Submit");
		resetButton = new JButton("Reset");
		submitButton.addActionListener(this);
		resetButton.addActionListener(this);
		sexRadioButton1 = new JRadioButton("Male");
		sexRadioButton2 = new JRadioButton("Female");
		sexRadioButton3 = new JRadioButton("Others");
		ButtonGroup bg = new ButtonGroup();
		bg.add(sexRadioButton1);
		bg.add(sexRadioButton2);
		bg.add(sexRadioButton3);
		c = infoFrame.getContentPane();
		setComponentBounds();
		setComponentFont();
		setComponentText();
		c.setLayout(null);                    //doubt
		addToContainer();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitButton){
			User user = getNewUserInfo();
			CreateUserController userController = new CreateUserController();
			boolean isUserCreated = userController.createUser(user);
			if(isUserCreated) {
				AlertBox.showInfo("User Created Successfully.Click OK to Login");
			}else {
				AlertBox.showInfo("Error Occured ,please try again");
			}
		}
	}
	public User getNewUserInfo() {
		User newUser = new User();
		newUser.setName(nameTextField.getText());
		newUser.setRollno(rollnoTextField.getText());
		newUser.setBloodGroup(bloodGroupTextField.getText());
		newUser.setBranch((String)branchComboBox.getItemAt(branchComboBox.getSelectedIndex()));
		newUser.setdOB(dOBTextField.getText());
		newUser.setSession((String)sessionComboBox.getItemAt(sessionComboBox.getSelectedIndex()));
		newUser.setMobileno(mobilenoTextField.getText());
		if(sexRadioButton1.isSelected()){
			newUser.setSex(sexRadioButton1.getText());
		}
		else {
			if(sexRadioButton2.isSelected()){
				newUser.setSex(sexRadioButton2.getText());
			}else{
				newUser.setSex(sexRadioButton3.getText());
			}
		}
		newUser.setRole(roleTextField.getText());
		newUser.setPassword(passwordTextField.getText());
		newUser.setConfirmPassword(confirmPasswordTextField.getText());
		return newUser;
	}
}
