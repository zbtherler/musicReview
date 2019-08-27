package com.music.review.sender;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.music.review.config.RabbitConfig;
import com.music.review.isender.IFanoutSender;

@Service
@Component
public class FanoutSender implements IFanoutSender{
	
	@Autowired
    private AmqpTemplate rabbitTemplate;
 
	@Override
    public void send(String user) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE, "", user);
    }

}
