package com.demo.util.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Auther: TX
 * @Date: 2019/1/24 14:54
 * @Description: 系统日志切面
 */
@Aspect
public class SystemLogAspect {

    //定义切点
    @Pointcut("@annotation(com.demo.util.annotation.SystemSeviceLog)")
    public void  servicePointcut(){
    }

    @Pointcut("@annotation(com.demo.util.annotation.SystemControllerLog)")
    public void  controllerPointcut(){
    }

    // 系统日志
    @Before("controllerPointcut()")
    public void before(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        Class<?> clazz = Class.forName(targetName);

    }

    // service 抛出错误记录
    @AfterThrowing("servicePointcut()")
    public void afterThrowException(JoinPoint joinPoint){

    }

}
