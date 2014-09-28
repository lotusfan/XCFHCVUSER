package com.xcfh.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail implements Runnable {
	private String toAddress;
	private String subject;
	private String text;

	public void sendMail(String toAddress, String subject, String text) throws Exception {

		this.toAddress = toAddress;
		this.subject = subject;
		this.text = text;
		Thread th = new Thread(this);
		th.start();

	}

	@ Override
	public void run() {

		try {

			String hostname = "smtp.exmail.qq.com";

			Properties props = System.getProperties();
			props.put("mail.transpot.protocol", "smtp");
			props.put("mail.store.protocol", "imap");
			props.put("mail.smtp.class", "com.sun.mail.smtp.SMTPTransport");
			props.put("mail.imap.class", "com.sun.mail.IMAPStore");
			props.put("mail.smtp.host", hostname);
			props.put("mail.smtp.auth", "true");

			Authenticator au = new Authenticator() {

				@ Override
				protected PasswordAuthentication getPasswordAuthentication() {

					// TODO Auto-generated method stub
					String username = "operator@hmammon.com";
					String password = "xcfhN120";
					return new PasswordAuthentication(username, password);
				}

			};
			Session mailsession = Session.getDefaultInstance(props, au);

			MimeMessage msg = new MimeMessage(mailsession);

			InternetAddress[] toAddrs = InternetAddress.parse(toAddress, false);

			msg.setRecipients(Message.RecipientType.TO, toAddrs);
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress("operator@hmammon.com"));
			msg.setText(text);

			Transport.send(msg);
			// TODO Auto-generated method stub
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
