package com.flm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminUserRegistrationFailedCount {
	 private static Scanner scan = new Scanner(System.in);
	
	public static void failedCount() {
	String query = "SELECT * FROM jfs_major_project.signup where email=? ";
	try {
	PreparedStatement pst = DAO.getConnection().prepareStatement(query);
	System.out.print("Enter E-mailId:");
	String email = scan.next();
	System.out.print("Enter Password:");
	String password = scan.next();
	pst.setString(1, email);
	ResultSet rs = pst.executeQuery();
	if (rs.next()) {
		String accountstatus=rs.getString("accountstatus");
		int failedcount=rs.getInt("failedcount");
		String userPassword=rs.getString("password");
		
		//failedcount
		
		if (userPassword.equals(password)) {
			System.out.println("Succesfully logged-in!!");
			FailedCountAccountStatus.resetfailedcount(email);
		} else {
			failedcount++;
			FailedCountAccountStatus.updatefailedcount(failedcount, email);
			//System.out.println("Invalid login credintals:"+failedcount+ "/5.");
			if (failedcount > 5) {
				FailedCountAccountStatus.failedaccountstatus(email);
				System.out.println("your account has locked due to more failed login attempts");
			}
		}
	}
	else {
		System.out.println("No user is found with this email...");
	}
}catch(SQLException e) {
	System.out.println("Error :"+e.getMessage());
}
	}
}
