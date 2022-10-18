package com.integrador.web.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrador.web.app.service.DocumentoSerieService;

@Controller
@RequestMapping("/documentoSerie")
public class DocumentoSerieController {
    
    @Autowired
    private DocumentoSerieService service;

    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> listarSeriesDocumento(){
        
    }


}