package com.znsd.sportslog.annotation;

import java.lang.annotation.*;

/**
 * Title: SystemControllerLog
 *
 * @version V1.0
 * Description:  自定义注解，拦截controller
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})//作用在参数和方法上
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Documented//表明这个注解应该被 javadoc工具记录
public @interface SystemControllerLog {
    String description() default "";//描述

    OperationType operationType() default OperationType.UNKNOWN;//操作类型
}