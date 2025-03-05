package com.flm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flm.dao.DAO;
import com.flm.dao.FailedCountAccountStatus;

public class Login {
	private Scanner scan=new Scanner(System.in);
	
	//to check whether user successfully login or not	
	//user login details and when it is invalid credentials more than 5 attempts we should locked the account
		public boolean  login() {
			String sql = "SELECT * FROM jfs_major_project.signup where email=? ";
			try{
				PreparedStatement ps =DAO.getConnection().prepareStatement(sql);
				System.out.print("Enter E-mailId:");
				String email = scan.nextLine();
				System.out.print("Enter Password:");
				String password = scan.nextLine();
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					String userPassword = rs.getString("password");
					int failedcount = rs.getInt("failedcount");
					String accountstatus = rs.getString("accountstatus");
					if (accountstatus.equals("locked")) {
						System.out.println("Your account is locked due to too many login attempts!!");
					}
					if (userPassword.equals(password)) {
						System.out.println("Succesfully logged-in!!");
						FailedCountAccountStatus.resetfailedcount(email);
						Login.addLoggedInUsers(email);
						return true;
					} else {
						failedcount++;
						System.out.println("Invalid login credintals:"+failedcount+ "/5.");
						FailedCountAccountStatus.updatefailedcount(failedcount, email);
						if (failedcount > 5) {
							FailedCountAccountStatus.failedaccountstatus(email);
							System.out.println("your account has locked due to more failed login attempts");
						}
					}
				}
				else {
							System.out.println("No user is found with this email...");
				}
			} catch (SQLException e) {
				System.out.println("Error :" + e.getMessage());
			}
			return false;
		}
			
			//store successfully logged-in users
			private static List<String>loggedInUsers=new ArrayList<>();
			private static void addLoggedInUsers(String email) {
				loggedInUsers.add(email);
			}

			//display logged-in-users
					private static void displayLoggedInUsers() {
					if(loggedInUsers.isEmpty()) {
						System.out.println("No users are logged-in...");
					}else {
						System.out.println("Currently logged-in users"+loggedInUsers);
					}
					}

		}
