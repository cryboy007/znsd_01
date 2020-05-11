package com.znsd.sportslog.annotation;

import java.lang.annotation.*;

/**
 * Title: SystemControllerLog
 *
 * @version V1.0
 * Description:  自定义注解，拦截service
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String description() default "";
}