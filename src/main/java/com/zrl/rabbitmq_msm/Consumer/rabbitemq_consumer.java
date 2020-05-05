package com.zrl.rabbitmq_msm.Consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

/*
 *@autho  zhengruilong
 *@date 2020-03-16
 */
//@RabbitListener(
//bindings = {
//        @QueueBinding(
////                队列
//                value = @Queue(name = "com",durable = "true"),
//                exchange =@Exchange(name = "exchange.direct",type = ExchangeTypes.DIRECT,durable ="true"),
//                key = {"com"}
//        )
//}
//)
@Component
@RabbitListener
public class rabbitemq_consumer {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    send send;
    private static  List list=new ArrayList();

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "com", durable = "true"),
            exchange = @Exchange(value = "exchange.direct", durable = "true", type = "direct"),
            key = "com"))
    @RabbitHandler
    public  void Listener_com(HashMap map,Message mes, Channel channel){
        System.out.println(map);
        if (map!=null){
            for (Object s:map.keySet() ) {
                int o = (int)map.get(s);
                String data="您的验证码是： 如需帮助请联系客服";
                String sms = com.zrl.rabbitmq_msm.Consumer.send.SMS(data, "http://sms.106jiekou.com/utf8/sms.aspx?account=ws_zero&password=147258369qazws&mobile="+s+"&content=您的手机号："+s+"，注册验证码："+o+"，请不要把验证码泄露给其他人。如非本人操作，可不用理会！");
                System.out.println(sms);
            }
        }


    }

}
