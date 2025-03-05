package com.flm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.flm.dao.AdminUserRegistrartionEmail;
import com.flm.dao.AdminUserRegistrationAccountStatus;
import com.flm.dao.AdminUserRegistrationFailedCount;
import com.flm.dao.DAO;
import com.flm.dao.FailedCountAccountStatus;

public class AdminUserRegistration {
	private  Scanner scan = new Scanner(System.in);
	
	//user details to signup
	public void signup() {
		AdminUserRegistrartionEmail.signup(null);
		String sql = "insert into signup(firstname,secondname,mobile,gender,email,password,failedcount,accountstatus)values(?,?,?,?,?,?,?,?)";
		try (PreparedStatement ps = DAO.getConnection().prepareStatement(sql);) {
			while (true) {
				System.out.println("Enter First Name(until'QUIT'):");
				String firstname = scan.next();
				if (firstname.equalsIgnoreCase("QUIT")) {
					break;
				}
				System.out.println("Enter Second Name:");
				String secondname = scan.next();
				System.out.println("Enter Mobile Number:");
				String mobile = scan.next();
				System.out.println("Enter Gender:");
				String gender = scan.next();
				System.out.println("Enter E-mailId:");
				String email = scan.next();
				System.out.println("Enter Password:");
				String password = scan.next();
				System.out.println("Enter failedcount:");
				int failedcount = scan.nextInt();
				System.out.println("Enter accountstatus:");
				String accountstatus = scan.next();
				ps.setString(1, firstname);
				ps.setString(2, secondname);
				ps.setString(3, mobile);
				ps.setString(4, gender);
				ps.setString(5, email);
				ps.setString(6, password);
				ps.setInt(7, failedcount);
				ps.setString(8, accountstatus);
				int[] result = ps.executeBatch();
			}
			//failed count
			AdminUserRegistrationFailedCount.failedCount();
			//account status
			AdminUserRegistrationAccountStatus.accountStatus();
		} catch (SQLException ex) {
			System.out.println("Error :" + ex.getMessage());
		}
	}
}
