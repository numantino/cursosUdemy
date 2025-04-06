package com.raul.curso.springboot.app.interceptor.springboot_interceptor.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        logger.info("LoadingTimeInterceptor: preHandle() entrando..." + ((HandlerMethod)handler).getMethod().getName());

        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        // Esto es para simular
        Random random = new Random();
        Thread.sleep(random.nextInt(500));

        // Personalizamos la salida en el caso que no se cumplan las condiciones
        //Map<String, String> json = new HashMap<>();
        //json.put("error", "Sin acceso a esta pagina");
        //ObjectMapper mapper = new ObjectMapper();
        //String jsonString = mapper.writeValueAsString(json);
        //response.setContentType("application/json");
        //response.setStatus(401);
        //response.getWriter().write(jsonString);
        //return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        logger.info("LoadingTimeInterceptor: postHandle() tiempo transcurrido: " + (end - start));
        logger.info("LoadingTimeInterceptor: postHandle() saliendo..." + ((HandlerMethod)handler).getMethod().getName());
    }

}
