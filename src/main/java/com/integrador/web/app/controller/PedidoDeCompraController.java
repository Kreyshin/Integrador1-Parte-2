package com.integrador.web.app.controller;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.integrador.web.app.common.Select;
import com.integrador.web.app.interfaces.IProveedor;
import com.integrador.web.app.model.Almacen;
import com.integrador.web.app.model.CondicionPago;
import com.integrador.web.app.model.Moneda;
import com.integrador.web.app.model.Interfaces.IBuscarProductos;
import com.integrador.web.app.model.Interfaces.IProveedorLista;
import com.integrador.web.app.service.AlmacenService;
import com.integrador.web.app.service.CondicionPagoService;
import com.integrador.web.app.service.MonedaService;
import com.integrador.web.app.service.ProductoService;
import com.integrador.web.app.service.ProveedorService;

@Controller
@RequestMapping("/pedidoCompra")
public class PedidoDeCompraController {

    @Autowired
    private AlmacenService AlmaService;

    @Autowired
    private MonedaService MoneService;

    
    @Autowired
    private CondicionPagoService CondPagoService;

    @Autowired
    private ProveedorService ProvService;

    @Autowired
    private ProductoService ProdService;

    @GetMapping("")
    public ModelAndView almacen(){
        return new ModelAndView("PedidoDeCompra/PedidoDeCompra");
    }

    @GetMapping("/cargarProveedores")
    @ResponseBody
    public Map<String,Object> cargarProveedores(){
        Map<String,Object> resultado = new HashMap<>();
        List<IProveedorLista> aList = ProvService.ListaProveedores();
        List<Select> list = new ArrayList<Select>() ;
        for (IProveedorLista proveedor : aList) {
            list.add(new Select(proveedor.getIdProv(),proveedor.getNomProv()));
        }
        resultado.put("lista", list);
        return resultado;
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

    @GetMapping("/filtrarProductos")
    @ResponseBody
    public Map<String,Object> filtrarProductos(String DesBusq){
        Map<String,Object> resultado = new HashMap<>();
        List<IBuscarProductos> list = ProdService.FiltrarProductos(DesBusq);
        resultado.put("lista", list);
        return resultado;
    }


}
