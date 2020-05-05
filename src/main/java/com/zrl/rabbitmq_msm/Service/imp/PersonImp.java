package com.zrl.rabbitmq_msm.Service.imp;

import com.zrl.rabbitmq_msm.Bean.Person;
import com.zrl.rabbitmq_msm.Dao.PersonDao;
import com.zrl.rabbitmq_msm.Service.PersonService;
import com.zrl.rabbitmq_msm.rabbitemq_publish.publish;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 *@autho  zhengruilong
 *@date 2020-03-16
 */
@Service
public class PersonImp implements PersonService {

    @Autowired
    publish publish;


    public void getTelToPublish(Long tel){
        publish.getTelToPublish(tel);
    }


}
