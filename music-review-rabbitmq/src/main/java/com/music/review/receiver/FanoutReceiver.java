package com.music.review.receiver;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.music.review.config.RabbitConfig;
import com.music.review.ireceiver.IFanoutReceiver;

@Component
public class FanoutReceiver implements IFanoutReceiver{

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
