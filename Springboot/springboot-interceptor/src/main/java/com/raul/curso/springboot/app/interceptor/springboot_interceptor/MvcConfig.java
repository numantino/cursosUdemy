package com.raul.curso.springboot.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Esto seria para excluir las rutas, se puede poner en lista
        // "/app/***" con esto se incluye todas las rutas
        //registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar");
        // Y esto es para aceptar todas y excluir las que quiero
        registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/bar");
    }
    
}
