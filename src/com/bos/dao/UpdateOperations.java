package com.bos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateOperations implements DatabaseConstants{
	Connection con = null;
	Statement st = null;

	public int update_balance(String accountNo, String balance) {
		int rows = 0;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();
			rows = st.executeUpdate("UPDATE account_details SET BALANCE = '" + balance + "' WHERE ACCOUNT_NO = '" + accountNo +"'");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
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
