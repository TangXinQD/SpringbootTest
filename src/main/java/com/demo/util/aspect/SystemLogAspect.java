package com.demo.util.aspect;

import com.demo.util.annotation.SystemControllerLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Auther: TX
 * @Date: 2019/1/24 14:54
 * @Description: 系统日志切面
 */
@Aspect
@Component
public class SystemLogAspect {

    //定义切点
    @Pointcut("@annotation(com.demo.util.annotation.SystemServiceLog)")
    public void  servicePointcut(){
    }

    @Pointcut("@annotation(com.demo.util.annotation.SystemControllerLog)")
    public void  controllerPointcut(){
    }

    // 系统日志
    @Before(value = "controllerPointcut()")
    public void before(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        Class<?> clazz = Class.forName(targetName);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if(name.equals(methodName)){
                String description = method.getAnnotation(SystemControllerLog.class).description();
            }
        }
    }

    // service 抛出错误记录
    @AfterThrowing(value = "servicePointcut()",throwing = "e")
    public void afterThrowException(JoinPoint joinPoint, Throwable e) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        Class<?> clazz = Class.forName(targetName);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if(name.equals(methodName)){
                String description = method.getAnnotation(SystemControllerLog.class).description();
            }
        }
    }

}
