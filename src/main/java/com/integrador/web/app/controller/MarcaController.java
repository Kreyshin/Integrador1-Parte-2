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

import com.integrador.web.app.model.Marca;
import com.integrador.web.app.service.MarcaService;

@Controller
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService service;

    @GetMapping("")
    public ModelAndView Categoria(){
        return new ModelAndView("Marca/Marca");
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> listarMarca(){
        Map<String,Object> resultado = new HashMap<>();
        List<Marca> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String,Object> insertarMarca(Marca marca){
        Map<String,Object> resultado = new HashMap<>();
        service.Insertar(marca);
        List<Marca> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @GetMapping("/buscarMarca")
    @ResponseBody
    public Map<String,Object> buscarMarca(int idMarc){
        Map<String,Object> resultado = new HashMap<>();
        Marca marca = service.BuscarPorId(idMarc);
        resultado.put("data", marca);
        return resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String,Object> actualizarMarca(Marca marca){
        Map<String,Object> resultado = new HashMap<>();
        service.Actualizar(marca);
        List<Marca> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String,Object> eliminarMarca(int idMarc){
        Map<String,Object> resultado = new HashMap<>();
        Marca marca = service.BuscarPorId(idMarc);
        service.Eliminar(marca);
        List<Marca> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }
}
