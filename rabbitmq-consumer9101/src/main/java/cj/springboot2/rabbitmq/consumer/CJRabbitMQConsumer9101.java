package cj.springboot2.rabbitmq.consumer;

import cj.springboot2.rabbitmq.consumer.config.CJRabbitMQProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {CJRabbitMQProperty.class})
@SpringBootApplication
public class CJRabbitMQConsumer9101 {
    public static void main(String[] args) {
        SpringApplication.run(CJRabbitMQConsumer9101.class, args);
    }
}
