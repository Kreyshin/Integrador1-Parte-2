package com.integrador.web.app.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
    
    @GetMapping(value="/")
    public ModelAndView Login(){
        return new ModelAndView("Login");
    }
    
    @GetMapping(value="/Inicio")
    public ModelAndView inicio(){
        return new ModelAndView("Index");
    }

    @PostMapping(value = "/IniciarSesion")
    @ResponseBody
    public Map<String,Object> inicarSesion(String usuario, String clave){
        Map<String,Object> resultado = new HashMap<>();
        System.out.println(clave);
        System.out.println(usuario);
        return resultado;
    }

}