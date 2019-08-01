package com.music.review.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import com.music.review.config.RabbitConfig;

@Component
public class FanoutSender {
	
	@Autowired
    private AmqpTemplate rabbitTemplate;
 
    public void send(String user) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE, "", user);
    }

}
