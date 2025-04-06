package com.raul.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raul.curso.springboot.webapp.springbootweb.controllers.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola") String message) {
        // El parametro se puede indicar con name, sino se tiene que llamar con el nombre de la variable
        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }
 
    // La forma de llamar la url: http://localhost:8090/api/params/bar?text=Hola%20que%20tal%20Raul&code=1
    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamDto param = new ParamDto();
        param.setMessage(text);
        param.setCode(code);

        return param;
    }

    @GetMapping("/request")
    public ParamDto requuest(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }
        ParamDto param = new ParamDto();
        param.setMessage(request.getParameter("text"));
        param.setCode(code);

        return param;
    }
    
}
