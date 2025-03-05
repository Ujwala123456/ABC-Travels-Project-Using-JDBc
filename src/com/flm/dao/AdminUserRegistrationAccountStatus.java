package com.flm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminUserRegistrationAccountStatus {
	 private static Scanner scan = new Scanner(System.in);
	 
	 public static void accountStatus() {
	 String query = "SELECT * FROM jfs_major_project.signup where email=?";
		try {
		PreparedStatement pst = DAO.getConnection().prepareStatement(query);
		System.out.print("Enter E-mailId:");
		String email = scan.next();
		System.out.print("Enter Password:");
		String password = scan.next();
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
	String userPassword=rs.getString("password");
	String accountstatus=rs.getString("accountstatus");
	if(userPassword.equals(password)&&accountstatus.equals("active")) {
		System.out.println("Succesfully logged-in");
	}else {
		System.out.println("Dont allow him to logged-in...");
	}
		}
		}catch(SQLException e) {
			System.out.println("Error :"+e.getMessage());
		}
}
}
