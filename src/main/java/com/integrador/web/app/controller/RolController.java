package com.integrador.web.app.controller;

import com.integrador.web.app.model.Rol;
import com.integrador.web.app.service.RolService;
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
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping("")
    public ModelAndView Rol(){
        return new ModelAndView("rol/Rol");
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String, Object> ListarRoles(){
        Map<String, Object> resultado = new HashMap<String,Object>();
        List<Rol> rolList = service.Listar();
        resultado.put("lista",rolList);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String, Object> InsertarRol(Rol obj){
        Map<String, Object> resultado = new HashMap<String,Object>();
        service.Insertar(obj);
        List<Rol> rolList = service.Listar();
        resultado.put("lista",rolList);
        return resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String, Object> ActualizarRol(Rol obj){
        Map<String, Object> resultado = new HashMap<String,Object>();
        service.Actualizar(obj);
        List<Rol> rolList = service.Listar();
        resultado.put("lista",rolList);
        return resultado;
    }

    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String, Object> EliminarRol(int Id){
        Map<String, Object> resultado = new HashMap<String,Object>();
        Rol rolEliminar = service.BuscarPorId(Id);
        service.Eliminar(rolEliminar);
        List<Rol> rolList = service.Listar();
        resultado.put("lista",rolList);
        return resultado;
    }


}
