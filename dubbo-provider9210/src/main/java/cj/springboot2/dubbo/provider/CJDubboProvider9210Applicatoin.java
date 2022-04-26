package cj.springboot2.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CJDubboProvider9210Applicatoin {
    public static void main(String[] args) {
        SpringApplication.run(CJDubboProvider9210Applicatoin.class,args);
//        new SpringApplicationBuilder(CJDubboProvider9210Applicatoin.class)
//                .web(WebApplicationType.NONE)
//                .run();
    }
}
