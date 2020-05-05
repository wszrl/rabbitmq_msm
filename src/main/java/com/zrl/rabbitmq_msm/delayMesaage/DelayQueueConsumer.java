package com.zrl.rabbitmq_msm.delayMesaage;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 *@autho  zhengruilong
 *@date 2020-03-17
 */
@Component
public class DelayQueueConsumer {

    @RabbitListener(queues = delayMessage.DELAY_QUEUE)
    public  void receiveDelayMessage(Integer milliseconds){
        System.out.println(milliseconds);
    }
}
