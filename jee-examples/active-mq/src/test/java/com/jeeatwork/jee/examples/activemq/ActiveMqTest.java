package com.jeeatwork.jee.examples.activemq;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.openejb.core.LocalInitialContextFactory;
import org.junit.Before;
import org.junit.Test;

public class ActiveMqTest {

	private Context context;

	@Before
	public void configureBroker() throws Exception {
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				LocalInitialContextFactory.class.getName());

		p.put("MyJmsResourceAdapter",
				"new://Resource?type=ActiveMQResourceAdapter");
		p.put("MyJmsResourceAdapter.ServerUrl", "tcp://localhost:61636");
		p.put("MyJmsResourceAdapter.BrokerXmlConfig", "");

		p.put("MyJmsConnectionFactory",
				"new://Resource?type=javax.jms.ConnectionFactory");
		p.put("MyJmsConnectionFactory.ResourceAdapter", "MyJmsResourceAdapter");

		p.put("MyJmsMdbContainer", "new://Container?type=MESSAGE");
		p.put("MyJmsMdbContainer.ResourceAdapter", "MyJmsResourceAdapter");

		p.put("qeustionQueue", "new://Resource?type=javax.jms.Queue");

		this.context = new InitialContext(p);
	}

	@Test
	public void test() throws Exception {
		ConnectionFactory cf = (ConnectionFactory) context
				.lookup("openejb:Resource/MyJmsConnectionFactory");

		Queue qeustionQueue = (Queue) context
				.lookup("openejb:Resource/qeustionQueue");
		
	
		Connection connection = cf.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        MessageProducer producer = session.createProducer(qeustionQueue);
        
        TextMessage message = session.createTextMessage("This is for you");
        
        producer.send(message);
        
        session.close();
        connection.close();
        
        
        connection = cf.createConnection();
        connection.start();

        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        MessageConsumer consumer = session.createConsumer(qeustionQueue);
        
        consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
				TextMessage tm = (TextMessage)message;
				try {
					System.out.println(tm.getText());
				}
				catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
        
        Thread.sleep(200);
        
        session.close();
        connection.close();
	}

}
