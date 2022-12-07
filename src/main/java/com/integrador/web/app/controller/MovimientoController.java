package com.integrador.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/movimiento")
public class MovimientoController {

    @GetMapping("")
    public ModelAndView almacen(){
        return new ModelAndView("Movimiento/Movimiento");
    }

}
