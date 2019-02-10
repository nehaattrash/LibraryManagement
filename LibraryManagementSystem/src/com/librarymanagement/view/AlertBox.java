package com.librarymanagement.view;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
public class AlertBox{
	public static void showInfo(String message){
		JOptionPane optionPane = new JOptionPane(message,JOptionPane.INFORMATION_MESSAGE);   //doubt
		JDialog dialog = optionPane.createDialog("Information!");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true); 
	}
} 