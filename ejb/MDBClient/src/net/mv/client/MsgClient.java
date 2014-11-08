package net.mv.client;



import java.util.Properties;
import java.util.Queue;

import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.*;


public class MsgClient {
	
	public static void main(String[] args) throws NamingException, JMSException{
		//get the context(Handle to EJB container)
		Properties props = new Properties();
		
		props.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		props.put(Context.PROVIDER_URL, "t3://localhost:7001");
		Context ctx = new InitialContext(props);
		
		Queue queue = (Queue)ctx.lookup("queue/MDBnew");
		
		//create QueueConnectionFactory
		
		QueueConnectionFactory qcf = (QueueConnectionFactory)ctx.lookup("jms/QCF");
		
		
		//create Queue Connection
		QueueConnection qc = qcf.createQueueConnection();
		
		//start QueueSession
		QueueSession session = qc.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		
		//Create message 
		TextMessage txt = session.createTextMessage("This is my MDB => Mark");
		
		//Create Sender object
		QueueSender sender = session.createSender((javax.jms.Queue) queue);
		
		sender.send(txt);
		
		System.out.println("sent message");
		
		sender.close();
		session.close();
		qc.close();
		
		
		
		
		
	}

}
