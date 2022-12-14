package com.bos.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.bos.dao.SelectOperations;
import com.bos.dao.UpdateOperations;
import com.bos.utility.EmailMessaging;

public class MoneyTransferPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fromAccountNo;
	private JTextField toAccountNo;
	private JTextField amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoneyTransferPage frame = new MoneyTransferPage("", "");
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
	public MoneyTransferPage(String username, String accountNo) {
		SelectOperations so = new SelectOperations();
		ArrayList<String> al = so.select_account_numbers();

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
		moneyTransferPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
				BalanceEnquiryPage bep = new BalanceEnquiryPage(username, accountNo);
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

		JLabel lblMoneyTransfer = new JLabel("MONEY TRANSFER");
		lblMoneyTransfer.setOpaque(true);
		lblMoneyTransfer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMoneyTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoneyTransfer.setForeground(new Color(102, 0, 0));
		lblMoneyTransfer.setFont(new Font("Euclid Circular A", Font.BOLD, 26));
		lblMoneyTransfer.setBackground(new Color(255, 238, 207));
		lblMoneyTransfer.setBounds(430, 152, 261, 33);
		contentPane.add(lblMoneyTransfer);

		JPanel moneyTransferSection = new JPanel();
		moneyTransferSection.setOpaque(false);
		moneyTransferSection.setBorder(new LineBorder(new Color(102, 0, 0), 2, true));
		moneyTransferSection.setBounds(276, 168, 569, 433);
		contentPane.add(moneyTransferSection);
		moneyTransferSection.setLayout(null);

		JLabel lblFrom = new JLabel("FROM");
		lblFrom.setFocusable(true);
		lblFrom.setForeground(Color.BLACK);
		lblFrom.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblFrom.setBounds(128, 68, 105, 29);
		moneyTransferSection.add(lblFrom);

		fromAccountNo = new JTextField("Enter Your Account Number");
		fromAccountNo.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (fromAccountNo.getText().equals("Enter Your Account Number")) {
					fromAccountNo.setText("");
					fromAccountNo.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fromAccountNo.getText().isEmpty()) {
					fromAccountNo.setForeground(Color.GRAY);
					fromAccountNo.setText("Enter Your Account Number");
				}
			}
		});
		fromAccountNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					fromAccountNo.setEditable(true);
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
					fromAccountNo.setEditable(true);
				} else {
					fromAccountNo.setEditable(false);
				}
			}
		});
		fromAccountNo.setForeground(Color.GRAY);
		fromAccountNo.setOpaque(false);
		fromAccountNo.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		fromAccountNo.setColumns(12);
		fromAccountNo.setCaretColor(Color.BLACK);
		fromAccountNo.setBorder(null);
		fromAccountNo.setBounds(128, 96, 310, 34);
		moneyTransferSection.add(fromAccountNo);

		JSeparator s1_1 = new JSeparator();
		s1_1.setForeground(new Color(102, 0, 0));
		s1_1.setBackground(new Color(102, 0, 0));
		s1_1.setBounds(128, 128, 310, 5);
		moneyTransferSection.add(s1_1);

		JLabel lblTo = new JLabel("TO");
		lblTo.setForeground(Color.BLACK);
		lblTo.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblTo.setFocusable(true);
		lblTo.setBounds(128, 156, 105, 29);
		moneyTransferSection.add(lblTo);

		toAccountNo = new JTextField("Enter Transferee's Account Number");
		toAccountNo.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (toAccountNo.getText().equals("Enter Transferee's Account Number")) {
					toAccountNo.setText("");
					toAccountNo.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (toAccountNo.getText().isEmpty()) {
					toAccountNo.setForeground(Color.GRAY);
					toAccountNo.setText("Enter Transferee's Account Number");
				}
			}
		});
		toAccountNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					toAccountNo.setEditable(true);
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
					toAccountNo.setEditable(true);
				} else {
					toAccountNo.setEditable(false);
				}
			}
		});
		toAccountNo.setOpaque(false);
		toAccountNo.setForeground(Color.GRAY);
		toAccountNo.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		toAccountNo.setColumns(12);
		toAccountNo.setCaretColor(Color.BLACK);
		toAccountNo.setBorder(null);
		toAccountNo.setBounds(128, 184, 310, 34);
		moneyTransferSection.add(toAccountNo);

		JSeparator s1_1_1 = new JSeparator();
		s1_1_1.setForeground(new Color(102, 0, 0));
		s1_1_1.setBackground(new Color(102, 0, 0));
		s1_1_1.setBounds(128, 216, 310, 5);
		moneyTransferSection.add(s1_1_1);

		JLabel lblAmount = new JLabel("AMOUNT");
		lblAmount.setForeground(Color.BLACK);
		lblAmount.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblAmount.setFocusable(true);
		lblAmount.setBounds(128, 247, 94, 29);
		moneyTransferSection.add(lblAmount);

		amount = new JTextField("Enter Amount to be Transferred");
		amount.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (amount.getText().equals("Enter Amount to be Transferred")) {
					amount.setText("");
					amount.setFont(new Font("Euclid Circular A", Font.BOLD, 23));
					amount.setForeground(new Color(102, 0, 0));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (amount.getText().isEmpty()) {
					amount.setText("Enter Amount to be Transferred");
					amount.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
					amount.setForeground(Color.GRAY);
				}
			}
		});
		amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					amount.setEditable(true);
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
					amount.setEditable(true);
				} else {
					amount.setEditable(false);
				}
			}
		});
		amount.setOpaque(false);
		amount.setForeground(Color.GRAY);
		amount.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		amount.setCaretColor(Color.BLACK);
		amount.setBorder(null);
		amount.setBounds(157, 274, 280, 34);
		moneyTransferSection.add(amount);

		JSeparator s1_1_1_1 = new JSeparator();
		s1_1_1_1.setForeground(new Color(102, 0, 0));
		s1_1_1_1.setBackground(new Color(102, 0, 0));
		s1_1_1_1.setBounds(128, 307, 310, 5);
		moneyTransferSection.add(s1_1_1_1);

		JLabel lblRupee = new JLabel("₹");
		lblRupee.setForeground(new Color(102, 0, 0));
		lblRupee.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRupee.setHorizontalAlignment(SwingConstants.CENTER);
		lblRupee.setFont(new Font("Dialog", Font.BOLD, 24));
		lblRupee.setBounds(122, 274, 34, 34);
		moneyTransferSection.add(lblRupee);

		JLabel toError = new JLabel("* Required");
		toError.setVisible(false);
		toError.setHorizontalTextPosition(SwingConstants.RIGHT);
		toError.setHorizontalAlignment(SwingConstants.RIGHT);
		toError.setForeground(Color.RED);
		toError.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		toError.setBounds(264, 156, 174, 29);
		moneyTransferSection.add(toError);

		JLabel amountError = new JLabel("* Required");
		amountError.setVisible(false);
		amountError.setHorizontalTextPosition(SwingConstants.RIGHT);
		amountError.setHorizontalAlignment(SwingConstants.RIGHT);
		amountError.setForeground(Color.RED);
		amountError.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		amountError.setBounds(264, 247, 174, 29);
		moneyTransferSection.add(amountError);

		JLabel fromError = new JLabel("* Required");
		fromError.setVisible(false);
		fromError.setHorizontalTextPosition(SwingConstants.RIGHT);
		fromError.setHorizontalAlignment(SwingConstants.RIGHT);
		fromError.setForeground(Color.RED);
		fromError.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		fromError.setBounds(264, 68, 174, 29);
		moneyTransferSection.add(fromError);

		JButton btnTransferMoney = new JButton("TRANSFER MONEY");
		btnTransferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valFromAccountNo, valToAccountNo, valAmount;

				valFromAccountNo = fromAccountNo.getText().equals("Enter Your Account Number");
				if (valFromAccountNo) {
					fromError.setText("* Required");
					fromError.setVisible(true);
				} else {
					valFromAccountNo = !(accountNo.equals(fromAccountNo.getText()));
					if (valFromAccountNo) {
						fromError.setText("* Invalid Account Number");
						fromError.setVisible(true);
					} else {
						fromError.setVisible(false);
					}
				}

				valToAccountNo = toAccountNo.getText().equals("Enter Transferee's Account Number");
				if (valToAccountNo) {
					toError.setText("* Required");
					toError.setVisible(true);
				} else {
					valToAccountNo = toAccountNo.getText().equals(accountNo);
					if (valToAccountNo) {
						toError.setText("* Invalid Account Number");
						toError.setVisible(true);
					} else {
						for (String element : al) {
							if (element.equals(toAccountNo.getText())) {
								valToAccountNo = false;
								break;
							} else {
								valToAccountNo = true;
							}
						}
						if (valToAccountNo) {
							toError.setText("* Invalid Account Number");
							toError.setVisible(true);
						} else {
							toError.setVisible(false);
						}
					}
				}

				valAmount = amount.getText().equals("Enter Amount to be Transferred");
				if (valAmount) {
					amountError.setText("* Required");
					amountError.setVisible(true);
				} else {
					for (int i = 0; i < amount.getText().length(); i++) {
						if (Character.isLetter(amount.getText().charAt(i))) {
							valAmount = true;
							break;
						} else {
							valAmount = false;
						}
					}
					if (valAmount) {
						amountError.setText("* Invalid Amount");
						amountError.setVisible(true);
					} else {
						valAmount = Integer.parseInt(amount.getText()) < 1;
						if (valAmount) {
							amountError.setText("* Invalid Amount");
							amountError.setVisible(true);
						} else {
							amountError.setVisible(false);
						}
					}
				}

				if (!(valFromAccountNo || valToAccountNo || valAmount)) {
					String[] options = { "CHECK" };
					JPanel panel = new JPanel();
					JLabel lbl = new JLabel("Enter Password to Confirm: ");
					JPasswordField pwd = new JPasswordField(10);
					panel.add(lbl);
					panel.add(pwd);
					int selectedOption = JOptionPane.showOptionDialog(null, panel, "Alert", JOptionPane.NO_OPTION,
							JOptionPane.WARNING_MESSAGE, null, options, options[0]);
					if (selectedOption == 0) {
						double fromBalance = Double.parseDouble(so.select_balance(accountNo));
						double toBalance = Double.parseDouble(so.select_balance(toAccountNo.getText()));
						double enteredAmount = Double.parseDouble(amount.getText());
						if (fromBalance > enteredAmount) {
							fromBalance -= enteredAmount;
							toBalance += enteredAmount;
							UpdateOperations uo = new UpdateOperations();
							int rows1 = uo.update_balance(accountNo, String.format("%.2f", fromBalance));
							int rows2 = uo.update_balance(toAccountNo.getText(), String.format("%.2f", toBalance));
							if (rows1 == 0 || rows2 == 0) {
								JOptionPane.showMessageDialog(null, "Error in Transferring!\nPlease Try Again!",
										"Error", JOptionPane.ERROR_MESSAGE);
							} else {
								EmailMessaging em = new EmailMessaging();
								em.send_notification(fromAccountNo.getText(), toAccountNo.getText(), amount.getText());
								JOptionPane.showMessageDialog(null, "Amount Transfer Successfull!", "Success",
										JOptionPane.INFORMATION_MESSAGE);
								myProfilePanel.setOpaque(true);
								Dashboard db = new Dashboard(username);
								db.setLocationRelativeTo(null);
								db.setVisible(true);
								dispose();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Insufficient Balance to Transfer!", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnTransferMoney.setForeground(Color.WHITE);
		btnTransferMoney.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		btnTransferMoney.setBorderPainted(false);
		btnTransferMoney.setBackground(new Color(102, 0, 0));
		btnTransferMoney.setBounds(178, 359, 212, 42);
		moneyTransferSection.add(btnTransferMoney);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/bgFinal.png")));
		bg.setBackground(Color.WHITE);
		bg.setVerticalTextPosition(SwingConstants.BOTTOM);
		bg.setVerticalAlignment(SwingConstants.BOTTOM);
		bg.setBounds(0, 0, 900, 650);
		contentPane.add(bg);
	}
}
