package com.gysoft.rabbitmq.demo.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/1/8 10:18
 */
//消息生产者
@Component
public class WorkSender {

    @Autowired
private AmqpTemplate amqpTemplate;


    //发送消息   一个发送多个接收  可通过channel改变消息分配策略，现在使用的是平均分配原则
    //点对点不要提前 建立队列和交换机的关系
    public  void workSend(String  msg){

        Date date = new Date();
        String context=msg+date;
        System.out.println("开始发送消息");
        amqpTemplate.convertAndSend("workQueues",context);
    }
}
