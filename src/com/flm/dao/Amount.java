package com.flm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Amount {
	private static Scanner scan = new Scanner(System.in);
	

	//to check whether amount with  no of seats
	public static void amount() {
		String sql = "select noofseats,amount from jfs_major_project.routes where id=? ";
		try {
			PreparedStatement pst= DAO.getConnection().prepareStatement(sql);
			System.out.println("Enter Id:");
			int id = scan.nextInt();
			pst.setInt(1, id);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				System.out.println("Enter NoOfSeats:");
				int noofseats = scan.nextInt();
				int seats = noofseats;
				double price = rst.getDouble("amount");
				double amountPerSeat = price * seats;
				System.out.println(amountPerSeat);
			}
		} catch (SQLException e) {
			System.out.println("Error :" + e.getMessage());
		}
	}
	
	//to store details of amount for no of seats to book bus tickets
		private static Set<Double>amount=new LinkedHashSet<>();
		public static void addamount(double amountPerSeat) {
			amount.add(amountPerSeat);
		}
	
}
