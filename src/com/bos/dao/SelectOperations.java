package com.bos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SelectOperations implements DatabaseConstants {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ArrayList<String> select_for_dashboard(String username) {
		ArrayList<String> al = new ArrayList<String>();
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery("SELECT FULL_NAME, MOBILE_NO, DOB, GENDER FROM REGISTRATION_TABLE WHERE EMAIL_ID = '"
					+ username + "'");
			while (rs.next()) {
				al.add(rs.getString("FULL_NAME"));
				al.add(rs.getString("MOBILE_NO"));
				al.add(rs.getString("DOB"));
				al.add(rs.getString("GENDER"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}
}
