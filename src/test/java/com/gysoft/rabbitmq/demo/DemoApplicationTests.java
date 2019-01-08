package com.gysoft.rabbitmq.demo;

import com.gysoft.rabbitmq.demo.message.FanoutSender;
import com.gysoft.rabbitmq.demo.message.TopicSender;
import com.gysoft.rabbitmq.demo.message.WorkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    WorkSender workSender;

    @Autowired
    TopicSender topicSender;
     @Autowired
    FanoutSender fanoutSender;

    //消息的确认机制  死信队列
    @Test
    public void sendMsg() {
        String msg=" hello Direct";
        //发送消息
        workSender.workSend(msg);
    }

    @Test
    public  void  testTopic(){
        String  msg="Hello Topic";

        topicSender.sendMSg(msg);
    }


    @Test
    public  void testFanout(){

        String msg=" hello Fanout";
        fanoutSender.sendMSg(msg);
    }
}

