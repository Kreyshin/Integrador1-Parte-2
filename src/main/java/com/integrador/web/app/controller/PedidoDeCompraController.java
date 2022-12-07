package com.integrador.web.app.controller;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.integrador.web.app.common.Select;
import com.integrador.web.app.model.Almacen;
import com.integrador.web.app.model.CondicionPago;
import com.integrador.web.app.model.Moneda;
import com.integrador.web.app.service.AlmacenService;
import com.integrador.web.app.service.CondicionPagoService;
import com.integrador.web.app.service.MonedaService;

@Controller
@RequestMapping("/pedidoCompra")
public class PedidoDeCompraController {

    @Autowired
    private AlmacenService AlmaService;

    @Autowired
    private MonedaService MoneService;

    
    @Autowired
    private CondicionPagoService CondPagoService;

    @GetMapping("")
    public ModelAndView almacen(){
        return new ModelAndView("PedidoDeCompra/PedidoDeCompra");
    }

    @GetMapping("/cargarAlmacenes")
    @ResponseBody
    public Map<String,Object> cargarAlmacenes(){
        Map<String,Object> resultado = new HashMap<>();
        List<Almacen> aList = AlmaService.Listar();
        List<Select> list = new ArrayList<Select>() ;
        for (Almacen almacen : aList) {
            list.add(new Select(almacen.getId(),almacen.getDesAlma()));
        }
        resultado.put("lista", list);
        return resultado;
    }

    @GetMapping("/cargarMonedas")
    @ResponseBody
    public Map<String,Object> cargarMonedas(){
        Map<String,Object> resultado = new HashMap<>();
        List<Moneda> aList = MoneService.Listar();
        List<Select> list = new ArrayList<Select>() ;
        for (Moneda moneda : aList) {
            list.add(new Select(moneda.getId(),moneda.getSimbolo() + "-" + moneda.getDesMoneda()));
        }
        resultado.put("lista", list);
        return resultado;
    }

    @GetMapping("/cargarCondicionesPago")
    @ResponseBody
    public Map<String,Object> cargarCodicionesPago(){
        Map<String,Object> resultado = new HashMap<>();
        List<CondicionPago> aList = CondPagoService.Listar();
        List<Select> list = new ArrayList<Select>() ;
        for (CondicionPago condicionPago : aList) {
            list.add(new Select(condicionPago.getId(), condicionPago.getDesCondPago()));
        }
        resultado.put("lista", list);
        return resultado;
    }

}
