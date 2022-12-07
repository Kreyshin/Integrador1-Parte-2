package com.integrador.web.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.integrador.web.app.service.EmpresaService;
import com.integrador.web.app.model.Empresa;
@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping("")
    public ModelAndView Empresa(){
        return new ModelAndView("Empresa/Empresa");
    }    

    @GetMapping("/buscarEmpresa")
    @ResponseBody
    public Map<String,Object> BuscarEmpresa(){
        Map<String, Object> resultado = new HashMap<>();
        Empresa empresa = service.BuscarPorId(1);
        resultado.put("data", empresa);
        return resultado;
    }   

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String,Object> actualizarEmpresa(Empresa empresa){
        Map<String, Object> resultado = new HashMap<>();
        service.Actualizar(empresa);
        return resultado;
    }

}
