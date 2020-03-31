package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.TestService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@EnableTransactionManagement
@Component
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner run (TestService testService) {
        return (args) -> {
            testService.doJob();
        };
    }


}
