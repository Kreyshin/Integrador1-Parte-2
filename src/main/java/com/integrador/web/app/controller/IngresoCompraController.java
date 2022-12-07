package com.integrador.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ingresoCompra")
public class IngresoCompraController {
    @GetMapping("")
    public ModelAndView almacen(){
        return new ModelAndView("IngresoCompra/IngresoCompra");
    }
}