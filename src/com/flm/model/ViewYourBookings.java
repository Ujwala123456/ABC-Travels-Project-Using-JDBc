package com.flm.model;

import java.util.Scanner;

public class ViewYourBookings {
	private static Scanner scan = new Scanner(System.in);
	
	public void viewYourBookings() {
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
   System.out.println("Customer First Name  : "+firstname);
   System.out.println("Customer Second Name : "+secondname);
   System.out.println("Booking_Id           : "+booking_id);
   System.out.println("Source               :  "+source);
   System.out.println("Destination          :  "+destination);
   System.out.println("Amount               :  "+amount);
   System.out.println("NoOfSeats            :  "+noofseats);
}
}

