package com.flm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
	private static Connection con = null;
	
	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jfs_major_project";
		String user = "root";
		String pwd = "Uja2578@";
		if (con == null) {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("Error :" + e.getMessage());
			}
			try {
				con =  DriverManager.getConnection(url, user, pwd);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return con;
	}
}