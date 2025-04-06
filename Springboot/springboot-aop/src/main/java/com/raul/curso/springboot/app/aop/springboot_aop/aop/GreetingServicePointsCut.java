package com.raul.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingServicePointsCut {

    @Pointcut("execution(* com.raul.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingLogggerPointCut(){}

    @Pointcut("execution(* com.raul.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingLogggerPointCutFoo(){}
}
