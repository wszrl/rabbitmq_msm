package com.zrl.rabbitmq_msm;

import com.zrl.rabbitmq_msm.delayMesaage.DelayQueueSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/*
 *@autho  zhengruilong
 *@date 2020-03-17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan("com.zrl.rabbitmq_msm.delayMesaage")
public class delayedMessage {

    @Autowired
    private DelayQueueSender delayQueueSender;
    @Test
    public void delayMes(){
        delayQueueSender.sendDelayQueue(9000);
    }
}
