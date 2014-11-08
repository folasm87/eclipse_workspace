package net.mv.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.JMSException;


@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, mappedName="queue/MDB")

public class MyMsgBean implements MessageListener {

    public void onMessage(Message message) {
        TextMessage txt = (TextMessage) message;
        
        try{
        	
        	System.out.println("in MDB: "  + txt.getText());
        }catch(JMSException e){
        	System.out.println("JMS error: " + e.getMessage());
        	e.printStackTrace();
        }
        
    }

}
