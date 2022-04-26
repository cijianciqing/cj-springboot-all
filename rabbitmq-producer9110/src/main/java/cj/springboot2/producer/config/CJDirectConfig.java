package cj.springboot2.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* 在Rabbit Servers声明Direct相关配置
* */
@Configuration
public class CJDirectConfig {

    @Autowired
    CJRabbitMQProperty cjRabbitMQProperty;

    // 声明 Direct Exchange
    @Bean
    public DirectExchange defineDirectExchange() {
       return ExchangeBuilder.directExchange(cjRabbitMQProperty.getExchang())
               .durable(true)
               .build();
    }

    //声明队列
    @Bean
    public Queue defineDirectQueue() {
        return QueueBuilder.durable(cjRabbitMQProperty.getQueue()).build();
    }

    // 绑定
    @Bean
    public Binding defineDirectBinding(@Qualifier("defineDirectQueue") Queue defineDirectQueue,
                                                 @Qualifier("defineDirectExchange") DirectExchange defineDirectExchange) {
        return BindingBuilder.bind(defineDirectQueue).to(defineDirectExchange).with(cjRabbitMQProperty.getBindingKey());
    }




}