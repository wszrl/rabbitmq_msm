package com.zrl.rabbitmq_msm.rabbitemq_publish;

/*
 *@autho  zhengruilong
 *@date 2020-03-16
 */

import antlr.StringUtils;
import com.zrl.rabbitmq_msm.Bean.Person;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class publish {

    @Autowired
    RabbitTemplate rabbitTemplate;
    RetryTemplate retryTemplate;
    //确认机制
    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        /**
         * correlationData: 回调的相关数据，包含了消息ID
         * ack: ack结果，true代表ack，false代表nack
         * cause: 如果为nack，返回原因，否则为null
         */
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.err.println("correlationData: " + correlationData);
            System.err.println("ack: " + ack);
            if(!ack){
                //做一些补偿机制等
                SimpleRetryPolicy policy = new SimpleRetryPolicy(5);
                retryTemplate.setRetryPolicy(policy);
                rabbitTemplate.setRetryTemplate(retryTemplate);
                System.err.println("异常处理....");
            }
        }
    };
    //返回机制
    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(org.springframework.amqp.core.Message message, int replyCode, String replyText,
                                    String exchange, String routingKey) {
            System.err.println("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
        }
    };


    private  static final Person p=new Person();



       private static  Map map=new HashMap();

       public void getTelToPublish(Long tel){

        int random = (int)((Math.random()*9+1)*100000);

        map.put(tel,random);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.convertAndSend("exchange.direct","com",map,new CorrelationData());

    }



//    //重发
//    @Bean
//    public MessageRecoverer messageRecoverer(RabbitTemplate rabbitTemplate){
//        return new RepublishMessageRecoverer(rabbitTemplate, "exchange.direct", "error_message");
//    }


}
