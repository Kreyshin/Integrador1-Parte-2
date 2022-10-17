package com.integrador.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/documento")
public class DocumentoController {



    @GetMapping("")
    public ModelAndView Documento(){
        return  new ModelAndView("Documento/Documento");
    }
}
