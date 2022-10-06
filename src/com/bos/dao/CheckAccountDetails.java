package com.bos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class CheckAccountDetails implements DatabaseConstants{
	HashMap<String, String> hm = new HashMap<String, String>();
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	public void select_account_details() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery("SELECT ACCOUNT_NO, BALANCE FROM account_details");
			while (rs.next()) {
				hm.put(rs.getString(1), rs.getString(2));
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
	}
}
