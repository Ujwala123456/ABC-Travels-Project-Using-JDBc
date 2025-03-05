package com.flm.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.flm.dao.DAO;
import com.flm.dao.RescheduleJourneyUsingBookID;

public class RescheduleYourJourney {
	private static  Scanner scan = new Scanner(System.in);
	
public void rescheduleJourney() {
	BookAJourney.BookJourney();
	RescheduleJourneyUsingBookID.rescheduleJourney(null, null);
}
}
