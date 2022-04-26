package cj.springboot2.rabbitmq.consumer.service;

import cj.springboot2.rabbitmq.consumer.config.CJRabbitMQProperty;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;


@Slf4j
@Component
public class CJRabbitMQConsumer {

    @Autowired
    CJRabbitMQProperty cjRabbitMQProperty;



    @RabbitListener(queues = "cjDirectQueueName")
    public void receiveMessage(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        log.info("获取Message时间: {},从队列过去信息: {}", new Date().toString(), msg);
    }
}