package com.bos.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class BalanceEnquiryPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField balanceAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceEnquiryPage frame = new BalanceEnquiryPage("", "");
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
	public BalanceEnquiryPage(String username, String accountNo) {
		SelectOperations so = new SelectOperations();

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

		JPanel hamburger_panel = new JPanel();
		hamburger_panel.setOpaque(false);
		hamburger_panel.setBackground(new Color(102, 0, 0));
		hamburger_panel.setBorder(null);
		hamburger_panel.setBounds(0, 120, 230, 533);
		contentPane.add(hamburger_panel);
		hamburger_panel.setLayout(null);

		JPanel myProfilePanel = new JPanel();
		myProfilePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myProfilePanel.setOpaque(true);
				Dashboard db = new Dashboard(username);
				db.setLocationRelativeTo(null);
				db.setVisible(true);
				dispose();
			}
		});
		myProfilePanel.setOpaque(false);
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
				MoneyTransferPage mtp = new MoneyTransferPage(username, accountNo);
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
		balanceEnquiryPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

		JLabel lblAvailableBalance = new JLabel("AVAILABLE BALANCE");
		lblAvailableBalance.setOpaque(true);
		lblAvailableBalance.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAvailableBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableBalance.setForeground(new Color(102, 0, 0));
		lblAvailableBalance.setFont(new Font("Euclid Circular A", Font.BOLD, 28));
		lblAvailableBalance.setBackground(new Color(255, 238, 207));
		lblAvailableBalance.setBounds(369, 167, 317, 33);
		contentPane.add(lblAvailableBalance);

		JPanel balanceEnquirySection = new JPanel();
		balanceEnquirySection.setLayout(null);
		balanceEnquirySection.setOpaque(false);
		balanceEnquirySection.setBorder(new LineBorder(new Color(102, 0, 0), 2, true));
		balanceEnquirySection.setBounds(345, 181, 439, 120);
		contentPane.add(balanceEnquirySection);

		balanceAmount = new JPasswordField(so.select_balance(accountNo));
		balanceAmount.setEchoChar('X');
		balanceAmount.setBorder(null);
		balanceAmount.setOpaque(false);
		balanceAmount.setEditable(false);
		balanceAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (balanceAmount.getEchoChar() == 'X') {
					balanceAmount.setEchoChar((char) 0);
				} else {
					balanceAmount.setEchoChar('X');
				}

			}
		});
		balanceAmount.setHorizontalAlignment(SwingConstants.LEFT);
		balanceAmount.setForeground(Color.BLACK);
		balanceAmount.setFont(new Font("Teko", Font.BOLD, 38));
		balanceAmount.setBounds(63, 34, 354, 57);
		balanceEnquirySection.add(balanceAmount);

		JLabel lblRupee = new JLabel("₹");
		lblRupee.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRupee.setHorizontalAlignment(SwingConstants.CENTER);
		lblRupee.setForeground(Color.BLACK);
		lblRupee.setFont(new Font("Teko", Font.BOLD, 38));
		lblRupee.setBounds(23, 34, 38, 57);
		balanceEnquirySection.add(lblRupee);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/bgFinal.png")));
		bg.setBackground(Color.WHITE);
		bg.setVerticalTextPosition(SwingConstants.BOTTOM);
		bg.setVerticalAlignment(SwingConstants.BOTTOM);
		bg.setBounds(0, 0, 900, 650);
		contentPane.add(bg);
	}
}
