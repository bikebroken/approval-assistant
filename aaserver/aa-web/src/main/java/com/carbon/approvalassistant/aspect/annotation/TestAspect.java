package com.carbon.approvalassistant.aspect.annotation;

import java.lang.annotation.*;

/**
 * @Author carbon
 * @Date 2020-08-13 23:56
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAspect {
}
