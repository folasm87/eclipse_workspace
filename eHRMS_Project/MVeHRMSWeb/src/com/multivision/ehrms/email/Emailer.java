package com.multivision.ehrms.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.multivision.ehrms.util.PropertyKeyReader;

/**
 * Component to send emails to the intended receipients. *
 * 
 * @author ESAKKIP
 */
public class Emailer {

	/**
	 * Post mail.
	 * 
	 * @param request
	 *            the request
	 * @param to
	 *            the to
	 * @param content
	 *            the content
	 * @param subject
	 *            the subject
	 * 
	 * @throws MessagingException
	 *             the messaging exception
	 * @throws Exception
	 *             the exception
	 */
	public void postMail(final String to, final String content,
			final String subject) throws MessagingException, Exception {
		PropertyKeyReader reader = new PropertyKeyReader();

		String host = reader.getKey("mail.server.host");
		String from = reader.getKey("mail.from.email.id");
		String password = reader.getKey("mail.user.id.pass");
		String port = reader.getKey("mail.smtp.port");

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		InternetAddress toAddress = new InternetAddress(to);
		message.addRecipient(Message.RecipientType.TO, toAddress);
		message.setSubject(subject);
		message.setText(content);
		Transport transport = session.getTransport("smtp");
		transport.connect(host, from, password);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();

	}

}
