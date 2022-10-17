package com.integrador.web.app.controller;

import com.integrador.web.app.model.Moneda;
import com.integrador.web.app.service.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/moneda")
public class MonedaController {

    @Autowired
    private MonedaService service;

    @GetMapping("")
    public ModelAndView Moneda() {
        return new ModelAndView("moneda/Moneda");
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String, Object> ListarMonedas(){
        Map<String, Object> resultado = new HashMap<>();
        List<Moneda> monedaList = service.Listar();
        resultado.put("lista", monedaList);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String, Object> InsertarMoneda(Moneda obj){
        Map<String, Object> resultado = new HashMap<>();
        service.Insertar(obj);
        List<Moneda> monedaList = service.Listar();
        resultado.put("lista", monedaList);
        return resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String, Object> ActualizarMoneda(Moneda obj){
        Map<String, Object> resultado = new HashMap<>();
        service.Actualizar(obj);
        List<Moneda> monedaList = service.Listar();
        resultado.put("lista", monedaList);
        return resultado;
    }

    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String, Object> EliminarMoneda(int Id){
        Map<String, Object> resultado = new HashMap<>();
        Moneda monedaEliminar = service.BuscarPorId(Id);
        service.Eliminar(monedaEliminar);
        List<Moneda> monedaList = service.Listar();
        resultado.put("lista", monedaList);
        return resultado;
    }
}
