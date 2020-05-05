package com.zrl.rabbitmq_msm.delayMesaage;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/*
 *@autho  zhengruilong
 *@date 2020-03-17
 */
@Configuration
public class delayMessage {
    public static final String DELAY_EXCHANGE = "DELAY_EXCHANGE";
    public static final String DELAY_QUEUE = "DELAY_QUEUE";
    public static final String DELAY_ROUTING_KEY = "DELAY_ROUTING_KEY";

    @Bean ("delayExchange")
    public CustomExchange delayExchange(){
        Map map=new HashMap();
        map.put("x-delayed-type","direct");
        return  new CustomExchange(DELAY_EXCHANGE,"fanout",true,false,map);
    }


    @Bean("delayQueue")
    public Queue delayQueue() {
        return QueueBuilder.durable(DELAY_QUEUE).build();
    }

    /**
     * 将延迟队列通过routingKey绑定到延迟交换器
     *
     * @return
     */
    @Bean
    public Binding delayQueueBindExchange() {
        return new Binding(DELAY_QUEUE, Binding.DestinationType.QUEUE, DELAY_EXCHANGE, DELAY_ROUTING_KEY, null);
    }}
