package com.zrl.rabbitmq_msm.rabbitemq_publish;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *@autho  zhengruilong
 *@date 2020-03-16
 */
@Configuration
public class MessageConverts {

    @Bean
    public MessageConverter simpleMessageListenerContainer(){
        return  new Jackson2JsonMessageConverter();

    }
}
