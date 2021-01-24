package com.carbon.approvalassistant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import java.security.Principal;
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
        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getName);
    }
}
