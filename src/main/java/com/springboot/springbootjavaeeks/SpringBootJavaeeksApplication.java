package com.springboot.springbootjavaeeks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringBootJavaeeksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJavaeeksApplication.class, args);
    }

}
