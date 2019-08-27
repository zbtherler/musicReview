package com.music.review.receiver;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.music.review.config.RabbitConfig;
import com.music.review.ireceiver.ITopicReceiver;

@Component
public class TopicReceiver implements ITopicReceiver{
	
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
