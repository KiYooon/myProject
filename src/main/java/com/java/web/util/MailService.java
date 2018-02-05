package com.java.web.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class MailService extends Authenticator {
	
	public static PasswordAuthentication account;
	
	public MailService(){
		account = new PasswordAuthentication("kiyoon1008", "rldbsl1");
	}
	
	public static int sendMail(HashMap<String, Object> paramMap) {
		int status = 0;
		
		// https://javaee.github.io/javamail/
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host","smtp.naver.com");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.port","587");

		Authenticator auth = new MailService();
		Session session = Session.getDefaultInstance(properties, auth);
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress();
			
			from = new InternetAddress("kiyoon1008@naver.com");
			msg.setFrom(from);
			
			InternetAddress to = new InternetAddress(paramMap.get("toMailAddr").toString());
			msg.setRecipient(Message.RecipientType.TO, to);
			
			msg.setSubject(paramMap.get("title").toString(), "UTF-8");
			msg.setText(paramMap.get("contents").toString(), "UTF-8");
			msg.setHeader("content-Type", "text/html");
			
			Transport.send(msg);
			status = 1;
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
		
		return status;
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return account;
	}
}
