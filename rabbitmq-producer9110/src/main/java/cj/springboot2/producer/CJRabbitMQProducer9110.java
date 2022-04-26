package cj.springboot2.producer;

import cj.springboot2.producer.config.CJRabbitMQProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {CJRabbitMQProperty.class})
@SpringBootApplication
public class CJRabbitMQProducer9110 {
    public static void main(String[] args) {
        SpringApplication.run(CJRabbitMQProducer9110.class, args);
    }
}
