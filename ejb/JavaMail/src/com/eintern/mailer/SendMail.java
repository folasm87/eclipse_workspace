package com.eintern.mailer;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) throws AddressException, MessagingException {
		final String host = "smtp.gmail.com"; //gmail
		//final String host = "smtp.mail.yahoo.com"; //yahoo
		final String port = "587"; //gmail
		//final String port = "25"; //yahoo
		final String from = "ayodeji.folashade@gmail.com";
		final String pwd = "SilkyVenom87";
		final String to = "rick@multivision.net";
		
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true" );
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(from, pwd);
			}
		});
		
		MimeMessage message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress(from));
		
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		message.setSubject("Javamail message - Mark Folashade");
		
		message.setText("This was sent using Javamail - Mark Folashade");
		
		Transport.send(message);
		
		System.out.println("Message sent...");

	}

}
