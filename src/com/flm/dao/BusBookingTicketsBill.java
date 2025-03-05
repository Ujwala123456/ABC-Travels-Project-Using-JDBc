package com.flm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BusBookingTicketsBill {
	private static Scanner scan = new Scanner(System.in);

	public static void bookJourney() {
		    System.out.print("Enter CustomerFirstName:");
		    String firstname=scan.next();
		    System.out.print("Enter CustomerSecondName:");
		    String secondname=scan.next();
			System.out.print("Enter BookingId:");
			String booking_id=scan.next();
			System.out.print("Enter Source:");
			String source=scan.next();
			System.out.print("Enter Destination:");
			String destination=scan.next();
			System.out.println("Enter Amount:");
			double amount=scan.nextDouble();
			System.out.println("Enter NoOfSeats:");
           int noofseats=scan.nextInt();
           System.out.println("\n-------------Bus Ticket Invoice-------");
           System.out.printf("Customer First Name  :  %s%n",firstname);
           System.out.printf("Customer Second Name :  %s%n",secondname);
           System.out.printf("Booking_Id           :  %s%n",booking_id);
		   System.out.printf("Source               :   %s%n",source);
		   System.out.printf("Destination          :  %s%n",destination);
		   System.out.printf("Amount               :  $%.2f%n",amount);
		   System.out.printf("NoOfSeats            :  %d%n",noofseats);
	}
}
