package com.flm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RescheduleJourneyUsingBookID {
private static Scanner scan=new Scanner(System.in);

//to check whether booked or not using booking-id to re-schedule journey
public static void rescheduleJourney(String newDate, String boooking_id) {
	String sql="SELECT booking_id FROM jfs_major_project.bookings WHERE booking_id=?";
	try {
		PreparedStatement pst=DAO.getConnection().prepareStatement(sql); 
		System.out.print("Enter BookingId:");
		String booking_id=scan.next();
		pst.setString(1, booking_id);
		ResultSet rs=pst.executeQuery();
		if(rs.next()) {
			String actualBooking_id=rs.getString("booking_id");
			if(actualBooking_id.equals(booking_id)) {
				updateDate(newDate,boooking_id);
				NoofSeats.noofseats();
				System.out.println("Rescheduled your journey successfully...");
				updateNoOfSeats();
				resetNoOfSeats();
			}
		}else {
		System.out.println("No Booking Exists,Please go back and first book the ticket...");
			}
	}catch(SQLException e) {
		System.out.println("Error :"+e.getMessage());
	}
}
//to re-schedule the new date where booking_id
public static void updateDate(String newDate,String booking_id) {
	String sql="UPDATE jfs_major_project.bookings SET date=? WHERE booking_id=?";
	try {
	PreparedStatement pst=DAO.getConnection().prepareStatement(sql); 
	System.out.print("Enter Date(YYYY-MM-DD):");
	 newDate=scan.next();
	System.out.print("Enter BookingId:");
	 booking_id=scan.next();
    pst.setString(1, newDate);
    pst.setString(2, booking_id);
    pst.executeUpdate();
}catch(SQLException e) {
	System.out.println("Error :"+e.getMessage());
}
}
//to reset the no of seats in routes table(increases seat)
public static void updateNoOfSeats() {
	String sql="UPDATE jfs_major_project.routes SET noofseats=? WHERE date=?";
	try {
		PreparedStatement pst=DAO.getConnection().prepareStatement(sql); 
		System.out.println("Enter No Of Seats:");
		int noofseats=scan.nextInt();
		System.out.println("Enter Date:");
		String date=scan.next();
		pst.setInt(1, noofseats);
		pst.setString(2, date);
	    pst.executeUpdate();
	}catch(SQLException e) {
		System.out.println("Error :"+e.getMessage());
	}
}
//to reset the no of seats in booking table(decreases seat)
public static void resetNoOfSeats() {
	String sql="UPDATE jfs_major_project.bookings SET noofseats=? WHERE booking_id=?";
	try {
		PreparedStatement pst=DAO.getConnection().prepareStatement(sql); 
		System.out.println("Enter No Of Seats:");
		int noofseats=scan.nextInt();
		System.out.println("Enter BookingId:");
		String booking_id=scan.next();
		pst.setInt(1, noofseats);
		pst.setString(2, booking_id);
	    pst.executeUpdate();
	}catch(SQLException e) {
		System.out.println("Error :"+e.getMessage());
	}
}
}





