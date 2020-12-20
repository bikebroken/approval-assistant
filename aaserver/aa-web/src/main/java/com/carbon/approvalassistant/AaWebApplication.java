package com.carbon.approvalassistant;

import com.carbon.approvalassistant.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class AaWebApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        log.info("Starting Approval Assistant... ");
        SpringApplication springApplication = new SpringApplication(AaWebApplication.class);
        //System.setProperty("server.servlet.context-path", "/ApprovalAssistant");
        springApplication.run(args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
    }

}
