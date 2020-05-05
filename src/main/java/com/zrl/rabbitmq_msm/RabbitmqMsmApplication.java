package com.zrl.rabbitmq_msm;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.zrl.rabbitmq_msm.Dao")
@EntityScan(basePackages = "com.zrl.rabbitmq_msm.Bean")
@EnableTransactionManagement
@EnableSwagger2
@EnableRabbit
public class RabbitmqMsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqMsmApplication.class, args);
    }

}
