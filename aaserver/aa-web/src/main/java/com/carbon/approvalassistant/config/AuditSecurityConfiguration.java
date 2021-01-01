package com.carbon.approvalassistant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @Author carbon
 * @Date 2020/12/29 下午11:14
 */
@Configuration
@EnableJpaAuditing
public class AuditSecurityConfiguration {

    @Bean
    AuditorAware<String> auditorAware() {
        return () -> Optional.of("admin");
    }
}
