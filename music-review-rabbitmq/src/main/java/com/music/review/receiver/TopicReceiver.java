package com.music.review.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import com.music.review.config.RabbitConfig;

@Component
public class TopicReceiver {
	
	// queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
    public void receiveTopic1(String user) {
        System.out.println("【receiveTopic1监听到消息】" + user.toString());
    }
    
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
    public void receiveTopic2(String user) {
        System.out.println("【receiveTopic2监听到消息】" + user.toString());
    }
}
