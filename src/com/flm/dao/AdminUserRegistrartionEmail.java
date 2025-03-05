package com.flm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminUserRegistrartionEmail {
private static Scanner scan=new Scanner(System.in);

public static void signup(String email) {
	String sql="select * from jfs_major_project.signup where email=?;";
	try {
		PreparedStatement pst = DAO.getConnection().prepareStatement(sql);
		System.out.print("Enter EmailID:");
		email=scan.next();
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		if(rs.next()) {
			String actualEmail=rs.getString("email");
			if(actualEmail.equals(email)) {
				System.out.println("Your email already exists...");
			}
		}else {
			System.out.println("Your eligible to signup...");
		}
	}catch(SQLException e) {
		System.out.println("Error :"+e.getMessage());
	}
}
}
