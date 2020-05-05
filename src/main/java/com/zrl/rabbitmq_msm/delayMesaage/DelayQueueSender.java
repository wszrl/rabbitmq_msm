package com.zrl.rabbitmq_msm.delayMesaage;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

/*
 *@autho  zhengruilong
 *@date 2020-03-17
 */
@Component
public class DelayQueueSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDelayQueue(int number) {

        // 这里的Exchange可以是业务的Exchange，为了方便测试这里直接往死信Exchange里投递消息
        rabbitTemplate.convertAndSend(
                delayMessage.DELAY_EXCHANGE, delayMessage.DELAY_ROUTING_KEY,
                number, (message) -> {
                    // 设置延迟的毫秒数
                    message.getMessageProperties().setDelay(number);
                    return message;
                });
    }
}
