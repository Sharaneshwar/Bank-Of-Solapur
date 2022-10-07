package com.bos.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.bos.dao.SelectOperations;
import javax.swing.border.MatteBorder;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField accountNo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard("");
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard(String username) {
		SelectOperations so = new SelectOperations();
		ArrayList<String> al = so.select_for_dashboard(username);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		JPanel headerPanel = new JPanel();
		headerPanel.setOpaque(false);
		headerPanel.setLayout(null);
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setAlignmentY(0.0f);
		headerPanel.setAlignmentX(0.0f);
		headerPanel.setBounds(0, 0, 900, 120);
		contentPane.add(headerPanel);

		JLabel closeLabel = new JLabel();
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeLabel.setIcon(new ImageIcon(HomePage.class.getResource("/resources/close_button.png")));
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Alert",
						JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					setVisible(false);
					dispose();
				}
			}
		});
		closeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setBounds(873, 3, 25, 25);
		headerPanel.add(closeLabel);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(HomePage.class.getResource("/resources/logo.png")));
		logo.setHorizontalTextPosition(SwingConstants.CENTER);
		logo.setHorizontalAlignment(SwingConstants.LEFT);
		logo.setForeground(Color.WHITE);
		logo.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		logo.setAlignmentY(0.0f);
		logo.setBounds(40, 26, 69, 67);
		headerPanel.add(logo);

		JLabel h1 = new JLabel("WE UNDERSTAND YOUR WORLD");
		h1.setBackground(Color.BLACK);
		h1.setHorizontalTextPosition(SwingConstants.LEFT);
		h1.setHorizontalAlignment(SwingConstants.LEFT);
		h1.setForeground(Color.BLACK);
		h1.setFont(new Font("Euclid Circular A", Font.BOLD, 19));
		h1.setAlignmentY(0.0f);
		h1.setBounds(119, 20, 376, 42);
		headerPanel.add(h1);

		JLabel h2 = new JLabel("BANK OF SOLAPUR");
		h2.setVerticalTextPosition(SwingConstants.TOP);
		h2.setVerticalAlignment(SwingConstants.TOP);
		h2.setHorizontalTextPosition(SwingConstants.LEFT);
		h2.setHorizontalAlignment(SwingConstants.LEFT);
		h2.setForeground(Color.BLACK);
		h2.setFont(new Font("Teko", Font.BOLD, 42));
		h2.setAlignmentY(0.0f);
		h2.setBounds(119, 46, 376, 49);
		headerPanel.add(h2);
		
		JPanel myProfileSection = new JPanel();
		myProfileSection.setOpaque(false);
		myProfileSection.setBorder(new LineBorder(new Color(102, 0, 0), 2, true));
		myProfileSection.setBounds(245, 134, 640, 500);
		contentPane.add(myProfileSection);
		myProfileSection.setLayout(null);

		JLabel mProfilePhoto = new JLabel("");
		mProfilePhoto.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/m_profile.png")));
		mProfilePhoto.setBounds(20, 20, 225, 225);
		myProfileSection.add(mProfilePhoto);

		JLabel fProfilePhoto = new JLabel("");
		fProfilePhoto.setVisible(false);
		fProfilePhoto.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/f_profile.png")));
		fProfilePhoto.setBounds(20, 20, 225, 225);
		myProfileSection.add(fProfilePhoto);

		if (al.get(3).equals("Female")) {
			mProfilePhoto.setVisible(false);
			fProfilePhoto.setVisible(true);
		}

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(102, 0, 0));
		separator.setForeground(new Color(102, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(255, 40, 3, 190);
		myProfileSection.add(separator);
		
		JLabel iconAccountNo = new JLabel("");
		iconAccountNo.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/acc_no_icon.png")));
		iconAccountNo.setForeground(Color.DARK_GRAY);
		iconAccountNo.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		iconAccountNo.setBounds(278, 92, 25, 25);
		myProfileSection.add(iconAccountNo);
		
		accountNo = new JPasswordField(al.get(0));
		accountNo.setEchoChar('X');
		accountNo.setBorder(null);
		accountNo.setOpaque(false);
		accountNo.setEditable(false);
		accountNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(accountNo.getEchoChar() == 'X') {
					accountNo.setEchoChar((char)0);
				} else {
					accountNo.setEchoChar('X');
				}
			}
		});
		accountNo.setEchoChar('X');
		accountNo.setForeground(Color.DARK_GRAY);
		accountNo.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		accountNo.setBounds(313, 92, 252, 25);
		myProfileSection.add(accountNo);

		JLabel name = new JLabel(al.get(1));
		name.setForeground(Color.BLACK);
		name.setHorizontalTextPosition(SwingConstants.CENTER);
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setFont(new Font("Euclid Circular A", Font.BOLD, 24));
		name.setBounds(278, 40, 322, 36);
		myProfileSection.add(name);

		JLabel iconEmail = new JLabel("");
		iconEmail.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/ico_email.png")));
		iconEmail.setForeground(Color.DARK_GRAY);
		iconEmail.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		iconEmail.setBounds(278, 128, 25, 25);
		myProfileSection.add(iconEmail);

		JLabel emailID = new JLabel(username);
		emailID.setForeground(Color.DARK_GRAY);
		emailID.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		emailID.setBounds(313, 128, 252, 25);
		myProfileSection.add(emailID);

		JLabel iconMobile = new JLabel("");
		iconMobile.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/phone_no_ico.png")));
		iconMobile.setForeground(Color.DARK_GRAY);
		iconMobile.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		iconMobile.setBounds(278, 164, 25, 25);
		myProfileSection.add(iconMobile);

		JLabel mobileNo = new JLabel(al.get(2));
		mobileNo.setForeground(Color.DARK_GRAY);
		mobileNo.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		mobileNo.setBounds(313, 164, 252, 25);
		myProfileSection.add(mobileNo);

		JLabel iconDob = new JLabel("");
		iconDob.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/birth-date-icon.png")));
		iconDob.setForeground(Color.DARK_GRAY);
		iconDob.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		iconDob.setBounds(278, 200, 25, 25);
		myProfileSection.add(iconDob);

		JLabel dob = new JLabel(al.get(3));
		dob.setForeground(Color.DARK_GRAY);
		dob.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		dob.setBounds(313, 200, 252, 25);
		myProfileSection.add(dob);
		
		JPanel advertisementPanel = new JPanel();
		advertisementPanel.setBorder(new LineBorder(new Color(102, 0, 0), 2, true));
		advertisementPanel.setBackground(new Color(255, 230, 178));
		advertisementPanel.setBounds(45, 267, 549, 193);
		myProfileSection.add(advertisementPanel);
		advertisementPanel.setLayout(null);
		
		JLabel lblvehicleLoan = new JLabel("VEHICLE LOAN");
		lblvehicleLoan.setForeground(Color.BLACK);
		lblvehicleLoan.setHorizontalTextPosition(SwingConstants.CENTER);
		lblvehicleLoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblvehicleLoan.setFont(new Font("Euclid Circular A", Font.BOLD, 15));
		lblvehicleLoan.setBounds(382, 10, 150, 19);
		advertisementPanel.add(lblvehicleLoan);
		
		JLabel lblhomeLoan = new JLabel("HOME LOAN");
		lblhomeLoan.setForeground(Color.BLACK);
		lblhomeLoan.setHorizontalTextPosition(SwingConstants.CENTER);
		lblhomeLoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblhomeLoan.setFont(new Font("Euclid Circular A", Font.BOLD, 15));
		lblhomeLoan.setBounds(200, 10, 150, 19);
		advertisementPanel.add(lblhomeLoan);
		
		JLabel lblpersonalLoan = new JLabel("PERSONAL LOAN");
		lblpersonalLoan.setForeground(Color.BLACK);
		lblpersonalLoan.setHorizontalTextPosition(SwingConstants.CENTER);
		lblpersonalLoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblpersonalLoan.setFont(new Font("Euclid Circular A", Font.BOLD, 15));
		lblpersonalLoan.setBounds(17, 10, 150, 19);
		advertisementPanel.add(lblpersonalLoan);
		
		JLabel personalLoan = new JLabel("");
		personalLoan.setBackground(new Color(255, 230, 178));
		personalLoan.setOpaque(true);
		personalLoan.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(102, 0, 0)));
		personalLoan.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/personal_loan.png")));
		personalLoan.setBounds(2, 0, 183, 153);
		advertisementPanel.add(personalLoan);
		
		JLabel vehicleLoan = new JLabel("");
		vehicleLoan.setBackground(new Color(255, 230, 178));
		vehicleLoan.setOpaque(true);
		vehicleLoan.setBorder(new MatteBorder(2, 2, 0, 0, (Color) new Color(102, 0, 0)));
		vehicleLoan.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/car_loan.png")));
		vehicleLoan.setBounds(366, 0, 181, 153);
		advertisementPanel.add(vehicleLoan);
		
		JLabel housingLoan = new JLabel("");
		housingLoan.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/home_loan.png")));
		housingLoan.setBounds(170, 0, 199, 153);
		advertisementPanel.add(housingLoan);
		
		JLabel applyLabel = new JLabel("VISIT NEAREST BOS BRANCH TO APPLY");
		applyLabel.setForeground(Color.BLACK);
		applyLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 20));
		applyLabel.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(102, 0, 0)));
		applyLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		applyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		applyLabel.setBounds(0, 153, 549, 40);
		advertisementPanel.add(applyLabel);

		JPanel hamburger_panel = new JPanel();
		hamburger_panel.setOpaque(false);
		hamburger_panel.setBackground(new Color(102, 0, 0));
		hamburger_panel.setBorder(null);
		hamburger_panel.setBounds(0, 120, 230, 533);
		contentPane.add(hamburger_panel);
		hamburger_panel.setLayout(null);

		JPanel myProfilePanel = new JPanel();
		myProfilePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		myProfilePanel.setBackground(new Color(102, 0, 0, 50));
		myProfilePanel.setBounds(0, 0, 231, 60);
		hamburger_panel.add(myProfilePanel);
		myProfilePanel.setLayout(null);

		JLabel label1 = new JLabel("My Profile");
		label1.setForeground(Color.BLACK);
		label1.setBounds(67, 0, 164, 60);
		myProfilePanel.add(label1);
		label1.setFont(new Font("Euclid Circular A", Font.BOLD, 17));

		JLabel logo1 = new JLabel("");
		logo1.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/profile_ico.png")));
		logo1.setBounds(21, 0, 46, 60);
		myProfilePanel.add(logo1);

		JSeparator s1 = new JSeparator();
		s1.setBackground(new Color(102, 0, 0));
		s1.setForeground(new Color(102, 0, 0));
		s1.setOrientation(SwingConstants.VERTICAL);
		s1.setBounds(20, 15, 3, 30);
		myProfilePanel.add(s1);

		JPanel moneyTransferPanel = new JPanel();
		moneyTransferPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				moneyTransferPanel.setOpaque(true);
				MoneyTransferPage mtp = new MoneyTransferPage(username, String.valueOf(accountNo.getPassword()));
				mtp.setLocationRelativeTo(null);
				mtp.setVisible(true);
				dispose();
			}
		});
		moneyTransferPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		moneyTransferPanel.setOpaque(false);
		moneyTransferPanel.setBackground(new Color(102, 0, 0, 50));
		moneyTransferPanel.setLayout(null);
		moneyTransferPanel.setBounds(0, 60, 231, 60);
		hamburger_panel.add(moneyTransferPanel);

		JSeparator hs1 = new JSeparator();
		hs1.setForeground(new Color(102, 0, 0));
		hs1.setBackground(new Color(102, 0, 0));
		hs1.setBounds(0, 0, 252, 12);
		moneyTransferPanel.add(hs1);

		JLabel label2 = new JLabel("Money Transfer");
		label2.setForeground(Color.BLACK);
		label2.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		label2.setBounds(67, 0, 162, 60);
		moneyTransferPanel.add(label2);

		JLabel logo2 = new JLabel("");
		logo2.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/money_transfer_ico.png")));
		logo2.setBounds(22, 1, 46, 60);
		moneyTransferPanel.add(logo2);

		JSeparator s2 = new JSeparator();
		s2.setOrientation(SwingConstants.VERTICAL);
		s2.setForeground(new Color(102, 0, 0));
		s2.setBackground(new Color(102, 0, 0));
		s2.setBounds(20, 15, 3, 30);
		moneyTransferPanel.add(s2);

		JPanel balanceEnquiryPanel = new JPanel();
		balanceEnquiryPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				balanceEnquiryPanel.setOpaque(true);
				BalanceEnquiryPage bep = new BalanceEnquiryPage(username, String.valueOf(accountNo.getPassword()));
				bep.setLocationRelativeTo(null);
				bep.setVisible(true);
				dispose();
			}
		});
		balanceEnquiryPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		balanceEnquiryPanel.setOpaque(false);
		balanceEnquiryPanel.setBackground(new Color(102, 0, 0, 50));
		balanceEnquiryPanel.setLayout(null);
		balanceEnquiryPanel.setBounds(0, 120, 231, 60);
		hamburger_panel.add(balanceEnquiryPanel);

		JSeparator hs2 = new JSeparator();
		hs2.setForeground(new Color(102, 0, 0));
		hs2.setBackground(new Color(102, 0, 0));
		hs2.setBounds(0, 0, 252, 12);
		balanceEnquiryPanel.add(hs2);

		JLabel label3 = new JLabel("Balance Enquiry");
		label3.setForeground(Color.BLACK);
		label3.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		label3.setBounds(67, 0, 162, 60);
		balanceEnquiryPanel.add(label3);

		JLabel logo3 = new JLabel("");
		logo3.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/rupee_ico.png")));
		logo3.setBounds(22, 0, 46, 60);
		balanceEnquiryPanel.add(logo3);

		JSeparator s3 = new JSeparator();
		s3.setOrientation(SwingConstants.VERTICAL);
		s3.setForeground(new Color(102, 0, 0));
		s3.setBackground(new Color(102, 0, 0));
		s3.setBounds(20, 15, 3, 30);
		balanceEnquiryPanel.add(s3);

		JSeparator hs3 = new JSeparator();
		hs3.setForeground(new Color(102, 0, 0));
		hs3.setBackground(new Color(102, 0, 0));
		hs3.setBounds(0, 58, 252, 12);
		balanceEnquiryPanel.add(hs3);

		JPanel logoutPanel = new JPanel();
		logoutPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logoutPanel.setOpaque(true);
				LoginPage lp = new LoginPage();
				lp.setLocationRelativeTo(null);
				lp.setVisible(true);
				dispose();
			}
		});
		logoutPanel.setOpaque(false);
		logoutPanel.setBackground(new Color(102, 0, 0, 50));
		logoutPanel.setLayout(null);
		logoutPanel.setBounds(0, 473, 231, 60);
		hamburger_panel.add(logoutPanel);

		JSeparator hs4 = new JSeparator();
		hs4.setForeground(new Color(102, 0, 0));
		hs4.setBackground(new Color(102, 0, 0));
		hs4.setBounds(0, 0, 252, 12);
		logoutPanel.add(hs4);

		JLabel label4 = new JLabel("Logout");
		label4.setForeground(Color.BLACK);
		label4.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		label4.setBounds(67, 0, 162, 60);
		logoutPanel.add(label4);

		JLabel logo4 = new JLabel("");
		logo4.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/ico_log_out.png")));
		logo4.setBounds(24, 0, 46, 60);
		logoutPanel.add(logo4);

		JSeparator s4 = new JSeparator();
		s4.setOrientation(SwingConstants.VERTICAL);
		s4.setForeground(new Color(102, 0, 0));
		s4.setBackground(new Color(102, 0, 0));
		s4.setBounds(20, 15, 3, 30);
		logoutPanel.add(s4);

		JLabel guidelines = new JLabel("");
		guidelines.setForeground(Color.BLACK);
		guidelines.setFont(new Font("Teko", Font.PLAIN, 38));
		guidelines.setBounds(0, 180, 230, 293);
		hamburger_panel.add(guidelines);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/bgFinal.png")));
		bg.setBackground(Color.WHITE);
		bg.setVerticalTextPosition(SwingConstants.BOTTOM);
		bg.setVerticalAlignment(SwingConstants.BOTTOM);
		bg.setBounds(0, 0, 900, 650);
		contentPane.add(bg);
	}
}
