package cj.springboot2.producer.controller;


import cj.springboot2.producer.config.CJRabbitMQProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/rabbitmq/producer")
public class CJRabbitMQProducer {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    CJRabbitMQProperty cjRabbitMQProperty;




    /*
     * 向exchange发送信息
     * */
    @GetMapping("/send/{message}")
    public void sendMsg(@PathVariable String message){
        log.info("Producer message send time: {},发送的消息: {}", new Date(), message);


        rabbitTemplate.convertAndSend(cjRabbitMQProperty.getExchang(),cjRabbitMQProperty.getBindingKey(),message);


    }
}
