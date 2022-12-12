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

			rs = st.executeQuery("SELECT ACCOUNT_NO FROM account_details WHERE EMAIL_ID = '" + username + "'");
			while (rs.next()) {
				al.add(rs.getString("ACCOUNT_NO"));
			}

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

	public int select_id_from_registration_table(String username) {
		int id = 0;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID FROM REGISTRATION_TABLE WHERE EMAIL_ID = '" + username + "'");
			while (rs.next()) {
				id = Integer.parseInt(rs.getString("ID"));
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
		return id;
	}

	public ArrayList<String> select_account_numbers() {
		ArrayList<String> al = new ArrayList<String>();
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();

			rs = st.executeQuery("SELECT ACCOUNT_NO FROM account_details");
			while (rs.next()) {
				al.add(rs.getString("ACCOUNT_NO"));
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

	public String select_balance(String accountNo) {
		String balance = "";
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery("SELECT BALANCE FROM account_details WHERE ACCOUNT_NO = '" + accountNo + "'");
			while (rs.next()) {
				balance = rs.getString("BALANCE");
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
		return balance;
	}

	public String select_password(String username) {
		String password = "";
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery("SELECT PASSWORD FROM registration_table WHERE EMAIL_ID = '" + username + "'");
			while (rs.next()) {
				password = rs.getString("PASSWORD");
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
		return password;
	}

	public String select_username(String accountNo) {
		String username = "";
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery("SELECT EMAIL_ID FROM account_details WHERE ACCOUNT_NO = '" + accountNo + "'");
			while (rs.next()) {
				username = rs.getString("EMAIL_ID");
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
		return username;
	}
}
