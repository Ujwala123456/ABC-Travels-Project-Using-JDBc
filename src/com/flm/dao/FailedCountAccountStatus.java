package com.flm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FailedCountAccountStatus {
	private static Connection con = null;
	
	// to reset the failedcount and find email i.e., initial failedcount=0
		public static void resetfailedcount(String email) {
			String sql = "update jfs_major_project.signup set failedcount=0 where email=?";
			try (PreparedStatement ps = DAO.getConnection().prepareStatement(sql)) {
				ps.setString(1, email);
				ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error :" + e.getMessage());
			}
		}
		
		// to update failedcount when increment the failedcount when it is invalid login
		// credentials
		public static void updatefailedcount(int failedcount, String email) {
			String sql = "update jfs_major_project.signup set failedcount=? where email=?";
			try (PreparedStatement ps =DAO. getConnection().prepareStatement(sql)) {
				ps.setInt(1, failedcount);
				ps.setString(2, email);
				ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error :" + e.getMessage());
			}
		}	

		// to check email whether password we retrun incorrect then  the  account status will be locked
		public static  void failedaccountstatus(String email) {
			String sql = "update jfs_major_project.signup set accountstatus='locked' where email=?";
			try (PreparedStatement ps = DAO.getConnection().prepareStatement(sql)) {
				ps.setString(1, email);
				ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Error :" + e.getMessage());
			}
	}
		
		// to check email whether email we retrun  correct  then  the  account status will be active 
				public static  void failedaccount(String email) {
					String sql = "update jfs_major_project.signup set accountstatus='active' where email=?";
					try (PreparedStatement ps = DAO.getConnection().prepareStatement(sql)) {
						ps.setString(1, email);
						ps.executeUpdate();
					} catch (SQLException e) {
						System.out.println("Error :" + e.getMessage());
					}
			}
}
