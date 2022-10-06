package com.bos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertOperations implements DatabaseConstants{
	Connection con = null;
	PreparedStatement ps = null;

	public int insert_into_registration_table(ArrayList<String> al) {
		int rows = 0;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = con.prepareStatement("INSERT INTO registration_table (FULL_NAME, DOB, MOBILE_NO, EMAIL_ID, ADDRESS, GENDER, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)");
			if (ps != null) {
				ps.setString(1, al.get(0));
				ps.setString(2, al.get(1));
				ps.setString(3, al.get(2));
				ps.setString(4, al.get(3));
				ps.setString(5, al.get(4));
				ps.setString(6, al.get(5));
				ps.setString(7, al.get(6));
				rows = ps.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}
	
	public int insert_into_account_details(String username) {
		int rows = 0;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = con.prepareStatement("INSERT INTO account_details (ID, EMAIL_ID, ACCOUNT_NO, BALANCE) VALUES (?, ?, ?, ?)");
			int id = new SelectOperations().select_id_from_registration_table(username);
			if (ps != null) {
				ps.setInt(1, id);
				ps.setString(2, username);
				ps.setString(3, String.format("34127856%04d", id));
				ps.setString(4, "1000.00");
				rows = ps.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}
}
