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

import com.integrador.web.app.model.TipoProveedor;
import com.integrador.web.app.service.TipoProveedorService;

@Controller
@RequestMapping("/tipoProveedor")
public class TipoProveedorController {

    @Autowired
    private TipoProveedorService service;

    @GetMapping("")
    public ModelAndView TipoProveedor(){
        return new ModelAndView("TipoProveedor/TipoProveedor");
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> listarTipoProveedor(){
        Map<String,Object> resultado = new HashMap<>();
        List<TipoProveedor> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String,Object> insertarTipoProveedor(TipoProveedor tipoProveedor){
        Map<String,Object> resultado = new HashMap<>();
        service.Insertar(tipoProveedor);
        List<TipoProveedor> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @GetMapping("/buscarTipoProveedor")
    @ResponseBody
    public Map<String,Object> buscarTipoProveedor(int idTipoProv){
        Map<String,Object> resultado = new HashMap<>();
        TipoProveedor tipoProv = service.BuscarPorId(idTipoProv);
        resultado.put("data", tipoProv);
        return resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String,Object> actualizarTipoProveedor(TipoProveedor tipoProveedor){
        Map<String,Object> resultado = new HashMap<>();
        service.Actualizar(tipoProveedor);
        List<TipoProveedor> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String,Object> eliminarTipoProveedor(int idTipoProv){
        Map<String,Object> resultado = new HashMap<>();
        TipoProveedor tipoProv = service.BuscarPorId(idTipoProv);
        service.Eliminar(tipoProv);
        List<TipoProveedor> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

}
