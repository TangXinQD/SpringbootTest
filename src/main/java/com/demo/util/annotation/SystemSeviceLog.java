package com.demo.util.annotation;

import java.lang.annotation.*;

/**
 * @Auther: TX
 * @Date: 2019/1/24 15:01
 * @Description: service层 切点注解
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})// 方法 参数注解
@Retention(RetentionPolicy.RUNTIME) //runtime
@Documented //javadoc
public @interface SystemSeviceLog {

    String description() default "";
}
