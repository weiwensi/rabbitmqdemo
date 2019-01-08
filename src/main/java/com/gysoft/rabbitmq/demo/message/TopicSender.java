package com.gysoft.rabbitmq.demo.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/1/8 10:57
 */

@Component //topic的方式实现消息的发送
public class TopicSender {

      @Autowired
    private AmqpTemplate rabbitTemplate;


      public  void sendMSg(String msg){

          String sendMsg = msg + new Date();

          System.out.println("---TopicSender 开始发送 " + sendMsg);

          this.rabbitTemplate.convertAndSend("topicExchange","topic.message",

                  sendMsg);

      }

}
