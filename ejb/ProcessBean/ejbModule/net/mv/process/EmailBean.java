package net.mv.process;

import javax.ejb.Stateless;


@Stateless
public class EmailBean implements Email {

	public void sendMail(String to){
		System.out.println("Sending mail to " + to);
	}

}
