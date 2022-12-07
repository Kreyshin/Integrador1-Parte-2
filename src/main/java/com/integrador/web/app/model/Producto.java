package com.integrador.web.app.model;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Producto")
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProducto")
    private int Id;
    private String CodProd;
    @ManyToOne(optional = false)
    private Categoria categoria;
    @ManyToOne(optional = false)
    private Marca marca;
    @ManyToOne(optional = false)
    private UnidadMedida unidadMedida;
    private String DesProd;
    private String NomProd;
    private String CodBarrProd;
    private Float ImpCost;
    private String IndExpi;
    private String SkuProd;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate FecExpi;  
    private String Estado;
    private String RutImage;
    private String CodCompProd;
    
    public Producto() {
    }

    public Producto(int id, String codProd, Categoria categoria, Marca marca, UnidadMedida unidadMedida, String desProd,
            String nomProd, String codBarrProd, Float impCost, String indExpi, String skuProd, LocalDate fecExpi,
            String estado, String rutImage, String codCompProd) {
        Id = id;
        CodProd = codProd;
        this.categoria = categoria;
        this.marca = marca;
        this.unidadMedida = unidadMedida;
        DesProd = desProd;
        NomProd = nomProd;
        CodBarrProd = codBarrProd;
        ImpCost = impCost;
        IndExpi = indExpi;
        SkuProd = skuProd;
        FecExpi = fecExpi;
        Estado = estado;
        RutImage = rutImage;
        CodCompProd = codCompProd;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCodProd() {
        return CodProd;
    }

    public void setCodProd(String codProd) {
        CodProd = codProd;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getDesProd() {
        return DesProd;
    }

    public void setDesProd(String desProd) {
        DesProd = desProd;
    }

    public String getNomProd() {
        return NomProd;
    }

    public void setNomProd(String nomProd) {
        NomProd = nomProd;
    }

    public String getCodBarrProd() {
        return CodBarrProd;
    }

    public void setCodBarrProd(String codBarrProd) {
        CodBarrProd = codBarrProd;
    }

    public Float getImpCost() {
        return ImpCost;
    }

    public void setImpCost(Float impCost) {
        ImpCost = impCost;
    }

    public String getIndExpi() {
        return IndExpi;
    }

    public void setIndExpi(String indExpi) {
        IndExpi = indExpi;
    }

    public String getSkuProd() {
        return SkuProd;
    }

    public void setSkuProd(String skuProd) {
        SkuProd = skuProd;
    }

    public LocalDate getFecExpi() {
        return FecExpi;
    }

    public void setFecExpi(LocalDate fecExpi) {
        FecExpi = fecExpi;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getRutImage() {
        return RutImage;
    }

    public void setRutImage(String rutImage) {
        RutImage = rutImage;
    }

    public String getCodCompProd() {
        return CodCompProd;
    }

    public void setCodCompProd(String codCompProd) {
        CodCompProd = codCompProd;
    }
    


}
