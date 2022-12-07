package com.integrador.web.app.interfaces;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public interface IProductoLista {
    Integer getIdProducto();
    String getCodProd();
    String getNomProd();
    String getDesCate();
    String getDesUnme();
    String getDesMarc();
    String getCodBarr();
    String getSkuProd();
    String getIndExpi();
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate getFecExpi();
    String getCodComp();
    Float getImpCost();
    String getEstado();
    
}