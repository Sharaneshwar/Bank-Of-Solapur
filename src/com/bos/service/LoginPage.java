package com.bos.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import com.bos.dao.CheckUsernamePassword;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		CheckUsernamePassword cup = new CheckUsernamePassword();
		cup.select_username_password();
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBackground(Color.WHITE);
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

		JLabel homeLabel = new JLabel();
		homeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/home_btn.png")));
		homeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to cancel the login?", "Alert",
						JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					HomePage hPage = new HomePage();
					hPage.setLocationRelativeTo(null);
					hPage.setVisible(true);
					dispose();
				}
			}
		});
		homeLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeLabel.setBounds(5, 5, 25, 25);
		headerPanel.add(homeLabel);

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
		
		JLabel LoginLabel = new JLabel("LOGIN");
		LoginLabel.setOpaque(true);
		LoginLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLabel.setForeground(new Color(102, 0, 0));
		LoginLabel.setFont(new Font("Euclid Circular A", Font.BOLD, 30));
		LoginLabel.setBackground(new Color(255, 238, 207));
		LoginLabel.setBounds(389, 166, 122, 35);
		contentPane.add(LoginLabel);

		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new LineBorder(new Color(102, 0, 0), 3, true));
		loginPanel.setOpaque(false);
		loginPanel.setBounds(257, 182, 385, 400);
		contentPane.add(loginPanel);
		loginPanel.setFont(new Font("Product Sans", Font.PLAIN, 16));
		loginPanel.setBackground(new Color(135, 206, 235));
		loginPanel.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFocusable(true);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblUsername.setBounds(42, 68, 105, 29);
		loginPanel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		lblPassword.setBounds(42, 144, 105, 29);
		loginPanel.add(lblPassword);

		JSeparator s1 = new JSeparator();
		s1.setForeground(new Color(102, 0, 0));
		s1.setBackground(new Color(102, 0, 0));
		s1.setBounds(42, 128, 300, 5);
		loginPanel.add(s1);

		username = new JTextField();
		username.setOpaque(false);
		username.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		username.setColumns(10);
		username.setCaretColor(Color.BLACK);
		username.setBorder(null);
		username.setBounds(42, 96, 300, 34);
		loginPanel.add(username);

		JSeparator s2 = new JSeparator();
		s2.setForeground(new Color(102, 0, 0));
		s2.setBackground(new Color(102, 0, 0));
		s2.setBounds(42, 203, 300, 5);
		loginPanel.add(s2);

		password = new JPasswordField();
		password.setOpaque(false);
		password.setFont(new Font("Euclid Circular A", Font.PLAIN, 16));
		password.setBorder(null);
		password.setBounds(42, 171, 260, 34);
		loginPanel.add(password);
		
		JLabel showHidePass = new JLabel("");
		showHidePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showHidePass.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/password_show.png")));
				password.setEchoChar((char)0);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				showHidePass.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/password_hide.png")));
				password.setEchoChar('•');
			}
		});
		showHidePass.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/password_hide.png")));
		showHidePass.setBounds(302, 171, 40, 34);
		loginPanel.add(showHidePass);

		JLabel loginError = new JLabel(
				"<html><center>\r\n* Incorrect Username or Password *<br>\r\nPlease try again!\r\n</center></html>");
		loginError.setVisible(false);
		loginError.setForeground(Color.RED);
		loginError.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		loginError.setHorizontalTextPosition(SwingConstants.CENTER);
		loginError.setHorizontalAlignment(SwingConstants.CENTER);
		loginError.setBounds(73, 333, 250, 42);
		loginPanel.add(loginError);

		JLabel req1 = new JLabel("* Required");
		req1.setVisible(false);
		req1.setForeground(Color.RED);
		req1.setHorizontalTextPosition(SwingConstants.RIGHT);
		req1.setHorizontalAlignment(SwingConstants.RIGHT);
		req1.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		req1.setBounds(218, 69, 124, 29);
		loginPanel.add(req1);

		JLabel req2 = new JLabel("* Required");
		req2.setVisible(false);
		req2.setHorizontalTextPosition(SwingConstants.RIGHT);
		req2.setHorizontalAlignment(SwingConstants.RIGHT);
		req2.setForeground(Color.RED);
		req2.setFont(new Font("Euclid Circular A", Font.PLAIN, 13));
		req2.setBounds(218, 145, 123, 29);
		loginPanel.add(req2);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valUsername, valPassword;
				valUsername = username.getText().equals("");
				if (valUsername) {
					req1.setVisible(true);
				} else {
					req1.setVisible(false);
				}

				valPassword = String.valueOf(password.getPassword()).equals("");
				if (valPassword) {
					req2.setVisible(true);
				} else {
					req2.setVisible(false);
				}

				if (!(valUsername || valPassword)) {
					if (cup.check_username_password(username.getText(), String.valueOf(password.getPassword()))) {
						loginError.setVisible(false);
						JOptionPane.showMessageDialog(null, "Login Successfull !", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						Dashboard dboard = new Dashboard(username.getText());
						dboard.setLocationRelativeTo(null);
						dboard.setVisible(true);
						dispose();
					} else {
						loginError.setVisible(true);
					}
				}
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Euclid Circular A", Font.BOLD, 17));
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(new Color(0, 128, 0));
		btnLogin.setBounds(141, 233, 115, 42);
		loginPanel.add(btnLogin);

		JLabel lblUseYourMobile = new JLabel("* Use registered email-ID as username *");
		lblUseYourMobile.setForeground(Color.BLACK);
		lblUseYourMobile.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUseYourMobile.setHorizontalAlignment(SwingConstants.CENTER);
		lblUseYourMobile.setFont(new Font("Euclid Circular A", Font.ITALIC, 14));
		lblUseYourMobile.setBounds(42, 28, 300, 29);
		loginPanel.add(lblUseYourMobile);

		JLabel register = new JLabel(
				"<html>\r\nDon't have an account?  <u style=\"color: blue\"> Register</u>\r\n</html>");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrationPage rp = new RegistrationPage();
				rp.setLocationRelativeTo(null);
				rp.setVisible(true);
				dispose();
			}
		});
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register.setHorizontalTextPosition(SwingConstants.CENTER);
		register.setHorizontalAlignment(SwingConstants.CENTER);
		register.setForeground(Color.BLACK);
		register.setFont(new Font("Euclid Circular A", Font.BOLD, 16));
		register.setBounds(48, 293, 300, 29);
		loginPanel.add(register);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(LoginPage.class.getResource("/resources/bgFinal.png")));
		bg.setBackground(Color.WHITE);
		bg.setVerticalTextPosition(SwingConstants.BOTTOM);
		bg.setVerticalAlignment(SwingConstants.BOTTOM);
		bg.setBounds(0, 0, 900, 650);
		contentPane.add(bg);
	}
}
