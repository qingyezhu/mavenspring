package com.wangzhu.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyMessageListener implements MessageListener {

	private static final Logger logger = LoggerFactory
			.getLogger(MyMessageListener.class);

	public void onMessage(Message message) {
		TextMessage msg = null;
		if (message instanceof TextMessage) {
			msg = (TextMessage) message;
			try {
				MyMessageListener.logger.info("Reading message:{}",
						msg.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			MyMessageListener.logger.info("Message of wrong type:{}", message
					.getClass().getName());
		}
	}

}
