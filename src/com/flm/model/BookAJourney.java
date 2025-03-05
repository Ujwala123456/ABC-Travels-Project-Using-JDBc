package com.flm.model;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import com.flm.dao.Amount;
import com.flm.dao.BookJourney;
import com.flm.dao.BookingTickets;
import com.flm.dao.BusBookingTicketsBill;
import com.flm.dao.NoofSeats;
import com.flm.dao.WeekendSurgeFee;

public class BookAJourney {
	private static Scanner scan = new Scanner(System.in);
	// users who logged succesfully allow them to book a bus tickets
	public static void BookJourney() {
		Login login = new Login();
		if (login.login()) {
			System.out.println("Your allowed to book bus tickets...");
			BookJourney.bookJourney();
			NoofSeats.noofseats();
			Amount.amount();
			WeekendSurgeFee.weekendSurgeFee();
			System.out.println("Enter the Number:");
			int num = scan.nextInt();
			switch (num) {
			case 1: {
				System.out.println("Are You Okay to book bus...");
				break;
			}
			case 2: {
				System.out.println("Are You Not Okay to book bus...");
				break;
			}
			}
			BookingTickets.bookinguser_id();
			BusBookingTicketsBill.bookJourney();
		} else {
			System.out.println("Your not allowed to book bus tickets...");
		}
		// BookAJourney.displayLoggedInUsers();
	}	
}