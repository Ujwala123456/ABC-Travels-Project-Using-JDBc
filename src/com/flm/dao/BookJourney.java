package com.flm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookJourney {
	private static Scanner scan = new Scanner(System.in);
	
	public static void bookJourney() {
		String query = "select source,destination,date from jfs_major_project.routes where source=? AND destination=? AND date=?";
		try {
			PreparedStatement pst = DAO.getConnection().prepareStatement(query);
			System.out.print("Enter Source:");
			String source = scan.nextLine();
			System.out.print("Enter Destination:");
			String destination = scan.nextLine();
			System.out.print("Enter Date(YYYY-MM-DD):");
			String date = scan.nextLine();
			pst.setString(1, source);
			pst.setString(2, destination);
			pst.setString(3, date);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				String actualSource=rs.getString("source");
				String actualDestination=rs.getString("destination");
				String actualDate=rs.getString("date");
			   if(actualSource.equals(source)&&actualDestination.equals(destination)&&actualDate.equals(date)){
				System.out.println("Route Matched....");
				}
			}else {
					System.out.println("No Route Matche,please go back and re-start to book bus tickets...");
				}
		} catch (SQLException e) {
			System.out.println("Error :" + e.getMessage());
		}
	}
}
