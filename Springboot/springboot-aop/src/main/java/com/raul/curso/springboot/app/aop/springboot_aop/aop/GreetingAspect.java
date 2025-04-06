package com.raul.curso.springboot.app.aop.springboot_aop.aop;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Before("GreetingServicePointsCut.greetingLogggerPointCut()")
    public void loggerBefore(JoinPoint joinpoint){
        String metodo = joinpoint.getSignature().getName();
        String args = Arrays.toString(joinpoint.getArgs());
        logger.info("Before: Metodo: " + metodo + " con los argumentos: " + args);
    }

    @After("GreetingServicePointsCut.greetingLogggerPointCut()")
    public void loggerAfter(JoinPoint joinpoint){
        String metodo = joinpoint.getSignature().getName();
        String args = Arrays.toString(joinpoint.getArgs());
        logger.info("After: Metodo: " + metodo + " con los argumentos: " + args);
    }

    @AfterReturning("GreetingServicePointsCut.greetingLogggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinpoint){
        String metodo = joinpoint.getSignature().getName();
        String args = Arrays.toString(joinpoint.getArgs());
        logger.info("AfterReturning: Metodo: " + metodo + " con los argumentos: " + args);
    }

    @AfterThrowing("GreetingServicePointsCut.greetingLogggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinpoint){
        String metodo = joinpoint.getSignature().getName();
        String args = Arrays.toString(joinpoint.getArgs());
        logger.info("AfterThrowing: Metodo: " + metodo + " con los argumentos: " + args);
    }

    @Around("GreetingServicePointsCut.greetingLogggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinpoint) throws Throwable{
        String metodo = joinpoint.getSignature().getName();
        String args = Arrays.toString(joinpoint.getArgs());

        Object result = null;
        try {
            logger.info("loggerAround(antes): Metodo: " + metodo + " con los argumentos: " + args);
            result = joinpoint.proceed();
            logger.info("loggerAround(despues): Metodo: " + metodo + " resultado: " + result);
        } catch (Throwable e) {
            logger.error("loggerAround(error): Metodo: " + metodo);
            throw e;
        }
        return result;
    }
}
