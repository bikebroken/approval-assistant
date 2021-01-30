package com.carbon.approvalassistant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class AaWebApplication {
    public static void main(String[] args) {
        log.info("Starting Approval Assistant... ");
        SpringApplication springApplication = new SpringApplication(AaWebApplication.class);
        springApplication.run(args);
    }
}
