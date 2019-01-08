package com.gysoft.rabbitmq.demo.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/1/8 11:01
 */

@Component
@RabbitListener(queues = "topic.queueA")
public class TopicReceiver1 {


     @RabbitHandler
    public void process(String msg) {
        //打印出来  历史记录也会打印出来？？？？
         System.out.println("TopicReceiveA 接受到了消息 :"+msg);

    }
}
