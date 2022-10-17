package com.integrador.web.app.controller;

import com.integrador.web.app.model.CondicionPago;
import com.integrador.web.app.service.CondicionPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
@RequestMapping("/condicionPago")
public class CondicionPagoController {

    @Autowired
    CondicionPagoService service;


    @GetMapping("")
    public ModelAndView CondicionPago(){
        return  new ModelAndView("CondicionPago/CondicionPago");
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> ListarCondicionesPago(){
        Map<String,Object> resultado = new HashMap<>();
        List<CondicionPago> condicionPagoList = service.Listar();
        resultado.put("lista", condicionPagoList);
        return  resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String,Object> InsertarCondicionPago(CondicionPago obj){
        Map<String,Object> resultado = new HashMap<>();
        service.Insertar(obj);
        List<CondicionPago> condicionPagoList = service.Listar();
        resultado.put("lista", condicionPagoList);
        return  resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String,Object> ActualizarCondicionPago(CondicionPago obj){
        Map<String,Object> resultado = new HashMap<>();
        service.Actualizar(obj);
        List<CondicionPago> condicionPagoList = service.Listar();
        resultado.put("lista", condicionPagoList);
        return  resultado;
    }

    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String,Object> ActualizarCondicionPago(int Id ){
        Map<String,Object> resultado = new HashMap<>();
        CondicionPago condicionPago = service.BuscarPorId(Id);
        service.Eliminar(condicionPago);
        List<CondicionPago> condicionPagoList = service.Listar();
        resultado.put("lista", condicionPagoList);
        return  resultado;
    }

    @GetMapping("/buscarPorId")
    @ResponseBody
    public Map<String,Object> BuscarPorIdCondicionPago(int Id){
        Map<String,Object> resultado = new HashMap<>();
        CondicionPago condicionPago = service.BuscarPorId(Id);
        resultado.put("data", condicionPago);
        return  resultado;
    }


}
