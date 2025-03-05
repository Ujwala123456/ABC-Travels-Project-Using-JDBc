package com;

import java.util.Scanner;

import com.flm.dao.Menu;
import com.flm.model.AdminUserRegistration;
import com.flm.model.BookAJourney;
import com.flm.model.Exit;
import com.flm.model.Login;
import com.flm.model.Logo;
import com.flm.model.RescheduleYourJourney;
import com.flm.model.UnlockTheAccount;
import com.flm.model.ViewYourBookings;

public class Test {

	public static void main(String[] arg) {
		Scanner scan = new Scanner(System.in);
		Logo l = new Logo();
		l.logo();
		AdminUserRegistration aur=new AdminUserRegistration();
		Login login=new Login();
		BookAJourney baj=new BookAJourney();
		RescheduleYourJourney ryj=new RescheduleYourJourney();
		ViewYourBookings vyb=new ViewYourBookings();
		UnlockTheAccount acc=new UnlockTheAccount();
		Exit ex=new Exit();
		Menu m=new Menu();
		m.menu();
		System.out.println("Enter a Number:");
		int input=scan.nextInt();
		switch(input) {
		case 1:{
			aur.signup();
			break;
		}
		case 2:{
			login.login();
			break;
		}
		case 3:{
			baj.BookJourney();
			break;
		}
		case 4 :{
			ryj.rescheduleJourney();
			break;
		}
		case 5:{
			vyb.viewYourBookings();
			break;
		}
		case 6:{
			acc.unlock();
			break;
		}
		case 7:{
			ex.exit();
			break;
		}
		}
			scan.close();
		}
}
