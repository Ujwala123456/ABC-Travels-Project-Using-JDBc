package com.flm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.flm.dao.DAO;
import com.flm.dao.FailedCountAccountStatus;

public class UnlockTheAccount {
	
	//to check whether user account status is locked so we should make it as active and failed count should be changed into 0 login or not	
	public void unlock() {
		String sql = "select*from jfs_major_project.signup where email =? ";
		try (PreparedStatement ps = DAO.getConnection().prepareStatement(sql); Scanner scan = new Scanner(System.in);) {
			System.out.print("Enter E-mailId:");
			String email = scan.next();
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				String userEmail = rs.getString("email");
				int failedcount = rs.getInt("failedcount");
				String accountstatus = rs.getString("accountstatus");
				if (accountstatus.equals("locked")&&userEmail.equals("email")) {
				}else {
					--failedcount;
					FailedCountAccountStatus.updatefailedcount(failedcount, email);
					FailedCountAccountStatus.failedaccount(email);
			System.out.println("Your account is unlocked succesfully...");
				}
			}
		}catch(SQLException e) {
			System.out.println("Error :"+e.getMessage());
		}
}

}
