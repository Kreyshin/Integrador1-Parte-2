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
import com.integrador.web.app.model.Categoria;
import com.integrador.web.app.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("")
    public ModelAndView Categoria(){
        return new ModelAndView("Categoria/Categoria");
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> listarCategoria(){
        Map<String,Object> resultado = new HashMap<>();
        List<Categoria> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String,Object> insertarCategoria(Categoria categoria){
        Map<String,Object> resultado = new HashMap<>();
        service.Insertar(categoria);
        List<Categoria> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @GetMapping("/buscarCategoria")
    @ResponseBody
    public Map<String,Object> buscarAlmacen(int idCate){
        Map<String,Object> resultado = new HashMap<>();
        Categoria categoria = service.BuscarPorId(idCate);
        resultado.put("data", categoria);
        return resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String,Object> actualizarCategoria(Categoria categoria){
        Map<String,Object> resultado = new HashMap<>();
        service.Insertar(categoria);
        List<Categoria> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

    @PostMapping("/eliminar")
    @ResponseBody
    public Map<String,Object> eliminarCategoria(int idCate){
        Map<String,Object> resultado = new HashMap<>();
        Categoria categoria = service.BuscarPorId(idCate);
        service.Eliminar(categoria);
        List<Categoria> aList = service.Listar();
        resultado.put("lista", aList);
        return resultado;
    }

}
