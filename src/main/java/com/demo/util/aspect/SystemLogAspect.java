package com.demo.util.aspect;

import com.demo.domain.Log;
import com.demo.service.LogService;
import com.demo.util.annotation.SystemControllerLog;
import com.demo.util.annotation.SystemServiceLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Auther: TX
 * @Date: 2019/1/24 14:54
 * @Description: 系统日志切面
 */
@Aspect
@Component
public class SystemLogAspect {

    @Resource
    private LogService logService;
    //本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    /**
     * 类型 :0-前置通知；1-异常通知
     **/
    public static final Byte LOG_TYPE_0 = 0;
    /**
     * 类型 :0-前置通知；1-异常通知
     **/
    public static final Byte LOG_TYPE_1 = 1;

    //-
    @Pointcut("@annotation(com.demo.util.annotation.SystemServiceLog)")
    public void  servicePointcut(){
    }

    @Pointcut("@annotation(com.demo.util.annotation.SystemControllerLog)")
    public void  controllerPointcut(){
    }

    // 系统日志
    @Before(value = "controllerPointcut()")
    public void before(JoinPoint joinPoint) throws ClassNotFoundException {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String ip = request.getRemoteAddr();
        try {
            Log log = new Log();
            log.setCreateTime(new Date());
            log.setDescription(getControllerDescription(joinPoint));
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.setRequestIp(ip);
            log.setType(LOG_TYPE_0);
            log.setArgs(getArgsString(joinPoint));

            logService.insert(log);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }




    // service 抛出错误记录
    @AfterThrowing(value = "servicePointcut()",throwing = "e")
    public void afterThrowException(JoinPoint joinPoint, Throwable e) throws ClassNotFoundException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String ip = request.getRemoteAddr();

        try {

            Log log = new Log();
            log.setCreateTime(new Date());
            log.setDescription(getServiceDescription(joinPoint));
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.setRequestIp(ip);
            log.setType(LOG_TYPE_1);
            log.setArgs(getArgsString(joinPoint));
            log.setExceptionCode(e.getClass().getName());
            log.setExceptionDetail(e.getMessage());

            logService.insert(log);
        }catch (Exception ep){
            ep.printStackTrace();
            logger.error(ep.getMessage());
        }
    }

    private String getControllerDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        Class<?> clazz = Class.forName(targetName);
        String description = "";
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if(name.equals(methodName)){
                description = method.getAnnotation(SystemControllerLog.class).description();
                String value = method.getAnnotation(SystemControllerLog.class).value();
                String s = generateKeyBySpEL(value, joinPoint);
                logger.info("SystemControllerLog:value:{}",s);
            }
        }

        return description;
    }

    private String getServiceDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        Class<?> clazz = Class.forName(targetName);
        String description = "";
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if(name.equals(methodName)){
                description = method.getAnnotation(SystemServiceLog.class).description();
            }
        }
        return description;
    }


    private String getArgsString(JoinPoint joinPoint) {
        StringBuffer sb = new StringBuffer();
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            sb.append(arg.toString());
        }
        return sb.toString();
    }


    /**
     * 用于SpEL表达式解析.
     */
    private SpelExpressionParser parser = new SpelExpressionParser();
    /**
     * 用于获取方法参数定义名字.
     */
    private DefaultParameterNameDiscoverer nameDiscoverer = new DefaultParameterNameDiscoverer();

    public String generateKeyBySpEL(String spELString, JoinPoint joinPoint) {
        // 通过joinPoint获取被注解方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 使用spring的DefaultParameterNameDiscoverer获取方法形参名数组
        String[] paramNames = nameDiscoverer.getParameterNames(method);
        // 解析过后的Spring表达式对象
        Expression expression = parser.parseExpression(spELString);
        // spring的表达式上下文对象
        EvaluationContext context = new StandardEvaluationContext();
        // 通过joinPoint获取被注解方法的形参
        Object[] args = joinPoint.getArgs();
        // 给上下文赋值
        for(int i = 0 ; i < args.length ; i++) {
            context.setVariable(paramNames[i], args[i]);
        }
        // 表达式从上下文中计算出实际参数值
        /*如:
            @annotation(key="#student.name")
             method(Student student)
             那么就可以解析出方法形参的某属性值，return “xiaoming”;
          */
        return expression.getValue(context).toString();
    }
}
