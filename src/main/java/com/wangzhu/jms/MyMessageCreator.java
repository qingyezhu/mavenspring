package com.wangzhu.jms;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.MessageCreator;

public class MyMessageCreator implements MessageCreator {

	private int msgNo;

	public MyMessageCreator(int msgNo) {
		this.msgNo = msgNo;
	}

	public Message createMessage(Session session) throws JMSException {
		TextMessage message = session.createTextMessage();
		message.setText(new Date() + "第" + msgNo + "条消息发出");
		return message;
	}

}
