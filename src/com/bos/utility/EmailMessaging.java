package com.bos.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bos.dao.SelectOperations;

public class EmailMessaging {
	public int send_notification(String fromAccountNo, String toAccountNo, String amount) {
		SelectOperations so = new SelectOperations();

		SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
		String message1 = String.format("<html><body><div style = \"font-size: 16px\">A/C holder <b>*%s</b> Debited for Rs. <b>%s</b> on <b>%s</b> to A/C holder <b>*%s</b>. Available Balance Rs. <b>%s</b><br>Thank You! - Bank Of Solapur</div></html>", fromAccountNo.substring(8), amount, format2.format(new Date()), toAccountNo.substring(8), so.select_balance(fromAccountNo));
		String message2 = String.format("<html><body><div style = \"font-size: 16px\">A/C holder <b>*%s</b> Credited for Rs. <b>%s</b> on <b>%s</b> by A/C holder <b>*%s</b>. Available Balance Rs. <b>%s</b><br>Thank You! - Bank Of Solapur</div></html>", toAccountNo.substring(8), amount, format2.format(new Date()), fromAccountNo.substring(8), so.select_balance(toAccountNo));
		String subject1 = String.format("Rs. %s debited from your BOS Account", amount);
		String subject2 = String.format("Rs. %s credited to your BOS Account", amount);
		String to1 = so.select_username(fromAccountNo);
		String to2 = so.select_username(toAccountNo);
		String from = "BOS Services <bos.mailservices@gmail.com>";

		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("bos.mailservices@gmail.com", "jklhkotedfphukuo");
			}
		});

		try {
			MimeMessage m = new MimeMessage(session);
			m.setFrom(new InternetAddress(from));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to1));
			m.setSubject(subject1);
			m.setContent(message1, "text/html");
			Transport.send(m);

			m = new MimeMessage(session);
			m.setFrom(new InternetAddress(from));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to2));
			m.setSubject(subject2);
			m.setContent(message2, "text/html");
			Transport.send(m);
		} catch (MessagingException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
}
