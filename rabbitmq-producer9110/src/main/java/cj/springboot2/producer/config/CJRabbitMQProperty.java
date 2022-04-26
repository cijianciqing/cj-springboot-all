package cj.springboot2.producer.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "cj.rabbitmq.direct")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CJRabbitMQProperty {

    private String exchang;
    private String queue;
    private String bindingKey;

}
