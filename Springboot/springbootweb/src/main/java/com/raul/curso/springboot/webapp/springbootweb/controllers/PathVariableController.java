package com.raul.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raul.curso.springboot.webapp.springbootweb.controllers.models.User;
import com.raul.curso.springboot.webapp.springbootweb.controllers.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String userNamame;

    @Value("${config.listofValues}")
    private List<String> listofValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{ '${config.listofValues}'.split(',')}")
    private List<String> valueList;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Autowired
    private Environment environtment;

    // url: http://localhost:8090/api/var/baz/mesa
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable() String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable() String product, @PathVariable() Integer id){

        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
                
        return user;
    }
    
    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();

        json.put("userNamame", userNamame);
        json.put("listofValues", listofValues);
        json.put("valueList", valueList);
        json.put("valuesMap", valuesMap);
        json.put("mensage", environtment.getProperty("config.mesage"));
        json.put("code", environtment.getProperty("config.code", Long.class));
        return json;
    }
    
}
