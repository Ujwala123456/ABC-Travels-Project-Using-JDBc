package com.flm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WeekendSurgeFee {
	private static Scanner scan = new Scanner(System.in);
	
	
	//to check whether it is weekend or not if it is weekend then amount will be increased
	public static  void weekendSurgeFee() {
		String sql = "select date,noofseats,amount from jfs_major_project.routes where id=?";
		try {
			PreparedStatement pst = DAO.getConnection().prepareStatement(sql);
			System.out.println("Enter Id:");
			int id = scan.nextInt();
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst.next()) {
				System.out.println("Enter NoOfSeats:");
				int noofseats=scan.nextInt();
				int seats = noofseats;
				double price = rst.getDouble("amount");
				double amountPerSeat = price * seats;
				LocalDate dt = LocalDate.parse(rst.getString("date"));
				DayOfWeek dayOfWeek=dt.getDayOfWeek();
				boolean isWeekend=(dayOfWeek==DayOfWeek.SATURDAY||dayOfWeek==DayOfWeek.SUNDAY);
				if(isWeekend) {
					double weekendSurgeFee=200*seats;
					System.out.println(weekendSurgeFee);
					double finalAmount = amountPerSeat+weekendSurgeFee;
					System.out.println(finalAmount);
				}
			}	
			}catch(SQLException e) {
				System.out.println("Error :"+e.getMessage());
			}
		}
	
	//to store details of its weekend then it will be charge more to book bus tickets
	private static Set<Double>weekendSurgeFee=new LinkedHashSet<>();
	public static void addweekendSurgeFee(double finalAmount) {
		weekendSurgeFee.add(finalAmount);
	}
	
}
