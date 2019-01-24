package com.demo.util.annotation;

import java.lang.annotation.*;

/**
 * @Auther: TX
 * @Date: 2019/1/24 15:05
 * @Description: controller层 切面注解
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})// 方法 参数注解
@Retention(RetentionPolicy.RUNTIME) //runtime
@Documented //javadoc
public @interface SystemControllerLog {

    String description() default "";
}
