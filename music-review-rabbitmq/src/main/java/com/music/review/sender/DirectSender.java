package com.music.review.sender;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.music.review.config.RabbitConfig;

@Component
public class DirectSender {

	 @Autowired
	 private RabbitTemplate rabbitTemplate;
	 
	 public void send(String user) {
	        this.rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE, "direct.pwl", user);
	 }

}
