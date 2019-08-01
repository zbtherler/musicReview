package com.music.review.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.music.review.config.RabbitConfig;

@Component
public class FanoutReceiver {

	// queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE1)
    public void receiveTopic1(String user) {
        System.out.println("【receiveFanout1监听到消息】" + user);
    }
 
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE2)
    public void receiveTopic2(String user) {
        System.out.println("【receiveFanout2监听到消息】" + user);
    }

}
