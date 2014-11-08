package net.mv.process;

import javax.ejb.Local;


@Local
public interface Email {
	
	public void sendMail(String to);
}
