package com.wangzhu.jms;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

public class SpringPublisher {

	private JmsTemplate template;
	private Destination topic;

	public JmsTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

	public Destination getTopic() {
		return topic;
	}

	public void setTopic(Destination topic) {
		this.topic = topic;
	}

	public void start() throws InterruptedException {
		int messageCount = 10;

		while ((--messageCount) > 0) {
			this.sendMessage(messageCount);
			Thread.sleep(1000);
		}
	}

	private void sendMessage(int msgNo) {
		template.send(topic, new MyMessageCreator(msgNo));
	}

}
