package com.integrador.web.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.integrador.web.app.model.UnidadMedida;
import com.integrador.web.app.service.UnidadMedidaService;

@Controller
@RequestMapping("/unidadMedida")
public class UnidadDeMedidaController {

    @Autowired
    private UnidadMedidaService service;

    @GetMapping("")
    public ModelAndView UnidadMedida(){
        return new ModelAndView("UnidadMedida/UnidadMedida");
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> listarUnidadMedida(){
        Map<String,Object> resultado = new HashMap<>();
        List<UnidadMedida> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String,Object> insertarUnidadMedida(UnidadMedida medida){
        Map<String,Object> resultado = new HashMap<>();
        service.Insertar(medida);
        List<UnidadMedida> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @GetMapping("/buscarUnidadMedida")
    @ResponseBody
    public Map<String,Object> buscarUnidadMedida(int idUnme){
        Map<String,Object> resultado = new HashMap<>();
        UnidadMedida medida = service.BuscarPorId(idUnme);
        resultado.put("data", medida);
        return resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String,Object> actualizarUnidadMedida(UnidadMedida medida){
        Map<String,Object> resultado = new HashMap<>();
        service.Insertar(medida);
        List<UnidadMedida> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String,Object> eliminarUnidadMedida(int idUnme){
        Map<String,Object> resultado = new HashMap<>();
        UnidadMedida medida = service.BuscarPorId(idUnme);
        service.Eliminar(medida);
        List<UnidadMedida> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }


}
