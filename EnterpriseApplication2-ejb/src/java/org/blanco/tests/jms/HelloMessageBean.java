/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blanco.tests.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 *
 * @author ablanco
 */
@MessageDriven(mappedName = "jms/hello_queue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class HelloMessageBean implements MessageListener {
    
    public HelloMessageBean() {
        
    }
    
    @Override
    public void onMessage(Message message) {
            System.out.println("Message Received: "+message);
            if (message instanceof TextMessage){
                try {
                    System.out.println("Message Text: "+
                            ((TextMessage)message).getText());
                } catch (JMSException ex) {
                    Logger.getLogger(HelloMessageBean.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
            
        
    }
}
