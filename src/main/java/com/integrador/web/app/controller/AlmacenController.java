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

import com.integrador.web.app.model.Almacen;
import com.integrador.web.app.model.Empresa;
import com.integrador.web.app.service.AlmacenService;
import com.integrador.web.app.service.EmpresaService;

@Controller
@RequestMapping("/almacen")
public class AlmacenController {

    @Autowired
    private AlmacenService service;

    @Autowired
    private EmpresaService serviceEmpr;

    @GetMapping("")
    public ModelAndView almacen(){
        return new ModelAndView("Almacen/Almacen");
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> listarAlmacenes(){
        Map<String,Object> resultado = new HashMap<>();
        List<Almacen> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String,Object> insertarAlmacene(Almacen almacen){
        Map<String,Object> resultado = new HashMap<>();
        Empresa empresa = serviceEmpr.BuscarPorId(1);
        almacen.setEmpresa(empresa);
        service.Insertar(almacen);
        List<Almacen> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @GetMapping("/buscarAlmacen")
    @ResponseBody
    public Map<String,Object> buscarAlmacen(int idAlma){
        Map<String,Object> resultado = new HashMap<>();
        Almacen almacen = service.BuscarPorId(idAlma);
        resultado.put("data", almacen);
        return resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String,Object> actualizarAlmacene(Almacen almacen){
        Map<String,Object> resultado = new HashMap<>();
        Empresa empresa = serviceEmpr.BuscarPorId(1);
        almacen.setEmpresa(empresa);
        service.Actualizar(almacen);
        List<Almacen> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String,Object> eliminarAlmacen(int idAlma){
        Map<String,Object> resultado = new HashMap<>();
        Almacen almacen = service.BuscarPorId(idAlma);
        service.Eliminar(almacen);
        List<Almacen> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }
}
