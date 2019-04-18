package com.sanshao.SpringBootDemo.logs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.sanshao.SpringBootDemo.logs.LogAnnotation)")
    public void pointCutDeclaration() {
    }


    //前置通知,方法执行之前执行
    @Before("pointCutDeclaration()")
    public void BeforeMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("BeforeMethod  The method   " + methodName + "   parameter is  " + Arrays.asList(args));
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        LogAnnotation loggerAnno = method.getAnnotation(LogAnnotation.class);
        System.out.println(loggerAnno.value());
    }

    //后置通知,方法执行之后执行(不管是否发生异常)
    @After("pointCutDeclaration()")
    public void AfterMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("AfterMethod  The method    " + methodName + "   parameter is  " + Arrays.asList(args));
    }

    //返回通知,方法正常执行完毕之后执行
    @AfterReturning(value = "pointCutDeclaration()", returning = "result")
    public void AfterReturningMethod(JoinPoint jp, Object result) {
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("AfterReturningMethod  The method   " + methodName + "   parameter is  " + Arrays.asList(args) + " " + result);
    }

    //异常通知,在方法抛出异常之后执行
    @AfterThrowing(value = "pointCutDeclaration()", throwing = "e")
    public void AfterThrowingMethod(JoinPoint jp, Exception e) {
        String methodName = jp.getSignature().getName();
        System.out.println("AfterThrowingMethod  The method   " + methodName + "exception :" + e);
    }


}
