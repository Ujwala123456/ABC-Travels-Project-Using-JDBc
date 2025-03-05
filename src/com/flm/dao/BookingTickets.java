package com.flm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookingTickets {
private static Scanner scan=new Scanner(System.in);


public static void bookinguser_id() {
String sql = "insert into jfs_major_project.bookings(booking_id,user_id,route_id,amount,noofseats)values(?,?,?,?,?)";
try {
	PreparedStatement pst= DAO.getConnection().prepareStatement(sql);
	System.out.print("Enter BookingId:");
	String  booking_id=scan.next();
	System.out.println("Enter UserId:");
	int user_id=scan.nextInt();
	System.out.println("Enter RoutesId:");
	int route_id=scan.nextInt();
	System.out.println("Enter Amount:");
	double amount=scan.nextDouble();
	System.out.println("Enter NoOfSeats:");
	int noofseats=scan.nextInt();
	pst.setString(1, booking_id);
	pst.setInt(2, user_id);
	pst.setInt(3, route_id);
	pst.setDouble(4, amount);
	pst.setInt(5, noofseats);
	int result=pst.executeUpdate();
	if(result>0) {
	System.out.println("Booking details stored Successfully....");
	}
	else {
		System.out.println("Failed to store booking details...");
	}
}catch(SQLException e) {
	System.out.println("Error :"+e.getMessage());
}
}
}
