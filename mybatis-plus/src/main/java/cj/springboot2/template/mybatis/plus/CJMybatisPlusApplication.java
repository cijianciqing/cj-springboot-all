package cj.springboot2.template.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("cj.springboot2.template.mybatis.plus.dao")
@SpringBootApplication
public class CJMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(CJMybatisPlusApplication.class, args);
    }

}
