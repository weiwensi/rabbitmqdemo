package com.gysoft.rabbitmq.demo.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/1/8 11:47
 */

@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;


    public  void sendMSg(String msg){

        String sendMsg = msg + new Date();

        System.out.println("---FanoutSender 开始发送 " + sendMsg);

        this.rabbitTemplate.convertAndSend("topicExchange","topic.message",

                sendMsg);

    }

}
