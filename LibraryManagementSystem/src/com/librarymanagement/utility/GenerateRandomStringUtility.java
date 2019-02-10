package com.librarymanagement.utility;
import java.util.Random;
public class GenerateRandomStringUtility {
		public static void generateRandomString(){
			String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			String newStr = "";
			Random rand = new Random();
			int n = str.length();
			for(int i = 0;i < 5;i++){
				newStr += str.charAt(rand.nextInt(n));
			}
			System.out.println("New String : "+newStr);
		}
		public static void main(String[] args){
			generateRandomString();
		}
}
