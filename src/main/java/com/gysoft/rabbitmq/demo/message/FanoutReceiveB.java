package com.gysoft.rabbitmq.demo.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/1/8 11:49
 */

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiveB {


    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiveB 接受到了消息 :"+msg);

    }
}
