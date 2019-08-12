package com.music.review.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.music.review.config.RabbitConfig;

@Component
public class DirectReceiver {

	@RabbitListener(queues = RabbitConfig.DIRECT_QUEUE1)
    public void receiveDirect1(String user) {
 
        System.out.println("【receiveDirect1监听到消息】" + user);
    }
 
    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE1)
    public void receiveDirect2(String user) {
 
        System.out.println("【receiveDirect2监听到消息】" + user);
    }
    
}
