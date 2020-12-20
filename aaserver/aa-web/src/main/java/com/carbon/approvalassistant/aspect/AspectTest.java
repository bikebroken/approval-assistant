package com.carbon.approvalassistant.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author carbon
 * @Date 2020-08-13 23:54
 */
@Aspect
@Component
public class AspectTest {

    @Around("@annotation(com.carbon.approvalassistant.aspect.annotation.TestAspect)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String userId = request.getParameter("userId");
        request.getParameterMap().put("userId", new String[]{userId + "fuck"});
        return joinPoint.proceed();

    }
}
