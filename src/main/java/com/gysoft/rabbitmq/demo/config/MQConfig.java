package com.gysoft.rabbitmq.demo.config;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/1/8 10:12
 */

@Configuration
public class MQConfig {

    //定义一个队列   用于测试点对点
    @Bean
    public Queue workQuen(){
    return new Queue("workQueues");
    }


    //----------------------topic  begin
    //话题队列    需要提前创建队列和交换 机的关系
    @Bean
    public Queue  topicQueueA(){
        return new Queue("topic.queueA",true);//true表示持久化该队列
    }

    @Bean
    public Queue  topicQueueB(){
        return new Queue("topic.queueB",true);//true表示持久化该队列
    }

    //声明交换机
    @Bean
    TopicExchange  topicExchange(){

        return   new TopicExchange("topicExchange");

    }
    //建立交换机和队列的关系

    @Bean    //和交换机a建立绑定
    public Binding  bindingA(){
        return  BindingBuilder.bind(topicQueueA()).to(topicExchange()).with("topic.message");  //这个with是哪个路由件
    }
    @Bean   //将交换机和队列B进行绑定
    public  Binding  bindingB(){
        return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with("topic.#");   //#匹配一个
    }
  //----------------------------topic  end


     //--------------------------------订阅模式 交换机，队列配置开始

      //所有的队列都会受到消息
      @Bean
      public Queue subscribeQueueA() {

          return new Queue("fanout.A");

      }

    @Bean
    public Queue subscribeQueueB() {

        return new Queue("fanout.B");

    }
    @Bean

    public Queue subscribeQueueC() {

        return new Queue("fanout.C");

    }
    //创建交换机
    @Bean
    public FanoutExchange fanoutExchange() {

        return new FanoutExchange("fanoutExchange");

    }
    //建立交换机绑定关系

    @Bean

    Binding bindingExchangeA(Queue subscribeQueueA,

                             FanoutExchange fanoutExchange) {

        // 绑定队列A到fanoutExchange交换机，也可以使用：bind(subscribeQueueA())进行绑定;

        return BindingBuilder.bind(subscribeQueueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue subscribeQueueB,

                             FanoutExchange fanoutExchange) {

        return BindingBuilder.bind(subscribeQueueB).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue subscribeQueueC,

                             FanoutExchange fanoutExchange) {

        return BindingBuilder.bind(subscribeQueueC).to(fanoutExchange);

    }


}
