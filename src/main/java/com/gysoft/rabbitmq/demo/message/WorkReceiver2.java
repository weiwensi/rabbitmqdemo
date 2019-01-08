package com.gysoft.rabbitmq.demo.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/1/8 10:24
 */

//用于消息的接受
@Component
@RabbitListener(queues = "workQueues")
public class WorkReceiver2 {

    //指定对消息的处理
    @RabbitHandler
public  void  process(String hello){

    System.out.println("workReceive2  接受到了消息"+hello);
}
}
