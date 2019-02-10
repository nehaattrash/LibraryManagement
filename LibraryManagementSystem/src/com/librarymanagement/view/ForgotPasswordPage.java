package com.librarymanagement.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.librarymanagement.base.BasePage;

public class ForgotPasswordPage implements ActionListener,BasePage {
	private JLabel  email ;
	private JTextField emailTextField;
	private JFrame forgotPasswordFrame;
	private Container c;
	private JButton okButton;
	@Override
	public void setComponentBounds() {
		forgotPasswordFrame.setBounds(500,500,500,500);
		email.setBounds(100,150 ,300,30);
		emailTextField.setBounds(200,150,300,50);
		okButton.setBounds(150,300,200,30);
	}

	@Override
	public void addToContainer() {
		c.add(email);
		c.add(emailTextField);
		c.add(okButton);
	}

	@Override
	public void setComponentText() {
		email.setText("Email");
	}

	@Override
	public void setComponentFont() {
		Font font = new Font("Arial",Font.BOLD,30);
		email.setFont(font);
		emailTextField.setFont(font);
	}
	public void createForgotPasswordFrame() {
		forgotPasswordFrame = new JFrame();
		forgotPasswordFrame.setVisible(true);
		forgotPasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forgotPasswordFrame.setTitle("Forgot Password");
		c = forgotPasswordFrame.getContentPane();
		email = new JLabel();
		emailTextField = new JTextField();
		c.setLayout(null);
		okButton = new JButton("OK");
		setComponentBounds();
		setComponentFont();
		setComponentText();
		okButton.addActionListener(this);
		addToContainer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okButton) {
			AlertBox.showInfo("Your password is sent to this email id!!");
		}
	}

}
