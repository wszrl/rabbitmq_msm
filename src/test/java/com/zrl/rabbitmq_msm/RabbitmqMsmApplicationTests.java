package com.zrl.rabbitmq_msm;

import com.zrl.rabbitmq_msm.Bean.Person;
import com.zrl.rabbitmq_msm.Dao.PersonDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class RabbitmqMsmApplicationTests {
    @Autowired
    PersonDao personDao;

//    测试jpa 联通数据库
    @Test
       void contextLoads() {
            Optional<Person> byId = personDao.findById(1);
        if (byId!=null){
            String person = byId.get().getTel();
            System.out.println(person);


        }

    }

}
