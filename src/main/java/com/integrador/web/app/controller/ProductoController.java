package com.integrador.web.app.controller;

import java.util.ArrayList;
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

import com.integrador.web.app.common.Select;
import com.integrador.web.app.interfaces.IProductoLista;
import com.integrador.web.app.model.Categoria;
import com.integrador.web.app.model.Marca;
import com.integrador.web.app.model.Producto;
import com.integrador.web.app.model.StockActual;
import com.integrador.web.app.model.UnidadMedida;
import com.integrador.web.app.service.CategoriaService;
import com.integrador.web.app.service.MarcaService;
import com.integrador.web.app.service.ProductoService;
import com.integrador.web.app.service.StockActualService;
import com.integrador.web.app.service.UnidadMedidaService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private CategoriaService CateServicio;

    @Autowired
    private UnidadMedidaService UnMeServicio;

    @Autowired
    private MarcaService  MarcServicio;

    @Autowired
    private ProductoService ProdServicio;

    @Autowired
    private StockActualService StockActuServicio;

    @GetMapping("")
    public ModelAndView almacen(){
        return new ModelAndView("Producto/Producto");
    }


    @GetMapping("/cargarCategorias")
    @ResponseBody
    public Map<String,Object> listarCategoria(){
        Map<String,Object> resultado = new HashMap<>();
        List<Categoria> aList = CateServicio.Listar();
        List<Select> list = new ArrayList<Select>() ;
        for (Categoria categoria : aList) {
            list.add(new Select(categoria.getId(),categoria.getDesCate()));
        }
        resultado.put("lista", list);
        return resultado;
    }

    @GetMapping("/cargarUnidadMedida")
    @ResponseBody
    public Map<String,Object> cargarUnidadesMedida(){
        Map<String,Object> resultado = new HashMap<>();
        List<UnidadMedida> aList = UnMeServicio.Listar();
        List<Select> list = new ArrayList<Select>() ;
        for (UnidadMedida unidadMedida : aList) {
            list.add(new Select(unidadMedida.getId(),unidadMedida.getDesUnme()));
        }
        resultado.put("lista", list);
        return resultado;
    }
    @GetMapping("/cargarMarca")
    @ResponseBody
    public Map<String,Object> cargarMarcas(){
        Map<String,Object> resultado = new HashMap<>();
        List<Marca> aList = MarcServicio.Listar();
        List<Select> list = new ArrayList<Select>() ;
        for (Marca marca : aList) {
            list.add(new Select(marca.getId(),marca.getDesMarc()));
        }
        resultado.put("lista", list);
        return resultado;
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String,Object> listarProductos(){
        Map<String,Object> resultado = new HashMap<>();
        List<IProductoLista> listProducto = ProdServicio.ListaProductos();
        resultado.put("lista", listProducto);
        return resultado;
    }

    @PostMapping("/insertar")
    @ResponseBody
    public Map<String,Object> insertarProducto(String queryData, int IdCate, int IdMarca, int IdUnme){
        Map<String,Object> resultado = new HashMap<>();
        try {
            Producto producto = ProdServicio.ParsearJsonModelo(queryData);
            Categoria categoria = CateServicio.BuscarPorId(IdCate);
            Marca marca = MarcServicio.BuscarPorId(IdMarca);
            UnidadMedida unidadMedida = UnMeServicio.BuscarPorId(IdUnme);
            producto.setCategoria(categoria);
            producto.setMarca(marca);
            producto.setUnidadMedida(unidadMedida);
            ProdServicio.Insertar(producto);
            StockActual stockActual = new StockActual();
            stockActual.setIdProducto(producto);
            stockActual.setCantActu(0);
            StockActuServicio.Insertar(stockActual);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 

        List<IProductoLista> listProducto = ProdServicio.ListaProductos();
        resultado.put("lista", listProducto);
        return resultado;
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public Map<String,Object> actualizarProducto(String queryData, int IdCate, int IdMarca, int IdUnme){
        Map<String,Object> resultado = new HashMap<>();
        try {
            Producto producto = ProdServicio.ParsearJsonModelo(queryData);
            Categoria categoria = CateServicio.BuscarPorId(IdCate);
            Marca marca = MarcServicio.BuscarPorId(IdMarca);
            UnidadMedida unidadMedida = UnMeServicio.BuscarPorId(IdUnme);
            producto.setCategoria(categoria);
            producto.setMarca(marca);
            producto.setUnidadMedida(unidadMedida);
            ProdServicio.Actualizar(producto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 

        List<IProductoLista> listProducto = ProdServicio.ListaProductos();
        resultado.put("lista", listProducto);
        return resultado;
    }
}
