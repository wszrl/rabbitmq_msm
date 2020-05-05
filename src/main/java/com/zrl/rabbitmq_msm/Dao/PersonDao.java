package com.zrl.rabbitmq_msm.Dao;

import com.zrl.rabbitmq_msm.Bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonDao extends JpaRepository<Person,Integer> {
}
