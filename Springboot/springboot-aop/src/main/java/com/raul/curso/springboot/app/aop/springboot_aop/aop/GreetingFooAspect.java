package com.raul.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("GreetingServicePointsCut.greetingLogggerPointCutFoo()")
    public void loggerBefore(JoinPoint joinpoint){
        String metodo = joinpoint.getSignature().getName();
        String args = Arrays.toString(joinpoint.getArgs());
        logger.info("Before(foo): Metodo: " + metodo + " con los argumentos: " + args);
    }
}
