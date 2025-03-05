package com.flm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import com.flm.dao.DAO;

public class NoofSeats {
	private static Scanner scan = new Scanner(System.in);
	
	//to check whether given data by no of seats are less than seats available 
	public static void noofseats() {
		String query = "select noofseats from jfs_major_project.routes where id=?";
		try {
			PreparedStatement pst = DAO.getConnection().prepareStatement(query);
			System.out.println("Enter Id:");
			int id = scan.nextInt();
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int availableSeats=rs.getInt("noofseats");
				System.out.println("Enter NoofSeats:");
				int noofseats = scan.nextInt();
				if (noofseats <= availableSeats) {
					System.out.println("Bus Available..");
					// System.out.println(id+":"+availableSeats);
				}else {
					System.out.println("There is No bus Available...");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error :" + e.getMessage());
		}
	}	
	
	//to store no of seats details for booking tickets
	private static Set<Integer>noofseatslist=new LinkedHashSet<>();
	private static void addnoofseatslist(int noofseats) {
		noofseatslist.add(noofseats);
	}
}
