package com.integrador.web.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PedidoCompraCabecera")
public class PedCompraCabecera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPediCompCabe")
    private int IdPediCompCabe;

    @ManyToOne(optional = false)
    @JoinColumn(name="IdEmpresa", nullable=false)
    private Empresa IdEmpresa;

    @ManyToOne(optional = false)
    @JoinColumn(name="IdAlmacen", nullable=false)
    private Almacen IdAlmacen;

    @ManyToOne(optional = false)
    @JoinColumn(name="IdCondPago", nullable=false)
    private CondicionPago IdCondPago;

    @ManyToOne(optional = true)
    @JoinColumn(name="IdUsuario", nullable=true)
    private Usuario IdUsuario;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="IdMoneda", nullable=false)
    private Moneda IdMoneda;

    @ManyToOne(optional = true)
    @JoinColumn(name="IdMoneBase", nullable=true)
    private Moneda IdMoneBase;

    
    @ManyToOne(optional = false)
    @JoinColumn(name="IdProv", nullable=false)
    private Proveedor IdProv;

    @Column(name = "NumPediComp")
    private String NumPediComp;

    @Column(name = "NumSeri")
    private String NumSeri;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "FecEmis")
    private LocalDate FecEmis;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "FecExpi")
    private LocalDate FecExpi;

    @Column(name = "FacCamb")
    private float FacCamb;

    @Column(name = "FacCambBase")
    private float FacCambBase;
    
    @Column(name = "PorIgv")
    private float PorIgv;

    @Column(name = "ImpIgv")
    private float ImpIgv;

    @Column(name = "ImpTota")
    private float ImpTota;

    @Column(name = "Observacion")
    private String Observacion;

    @Column(name = "Estado")
    private String Estado;

    @Column(name = "Atencion")
    private String Atencion;

    
    @Column(name = "Direccion")
    private String Direccion;

    public PedCompraCabecera() {
    }

    public PedCompraCabecera(int idPediCompCabe, Empresa idEmpresa, Almacen idAlmacen, CondicionPago idCondPago,
            Usuario idUsuario, Moneda idMoneda, Moneda idMoneBase, Proveedor idProv, String numPediComp, String numSeri,
            LocalDate fecEmis, LocalDate fecExpi, float facCamb, float facCambBase, float porIgv, float impIgv,
            float impTota, String observacion, String estado, String atencion, String direccion) {
        IdPediCompCabe = idPediCompCabe;
        IdEmpresa = idEmpresa;
        IdAlmacen = idAlmacen;
        IdCondPago = idCondPago;
        IdUsuario = idUsuario;
        IdMoneda = idMoneda;
        IdMoneBase = idMoneBase;
        IdProv = idProv;
        NumPediComp = numPediComp;
        NumSeri = numSeri;
        FecEmis = fecEmis;
        FecExpi = fecExpi;
        FacCamb = facCamb;
        FacCambBase = facCambBase;
        PorIgv = porIgv;
        ImpIgv = impIgv;
        ImpTota = impTota;
        Observacion = observacion;
        Estado = estado;
        Atencion = atencion;
        Direccion = direccion;
    }

    public int getIdPediCompCabe() {
        return IdPediCompCabe;
    }

    public void setIdPediCompCabe(int idPediCompCabe) {
        IdPediCompCabe = idPediCompCabe;
    }

    public Empresa getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        IdEmpresa = idEmpresa;
    }

    public Almacen getIdAlmacen() {
        return IdAlmacen;
    }

    public void setIdAlmacen(Almacen idAlmacen) {
        IdAlmacen = idAlmacen;
    }

    public CondicionPago getIdCondPago() {
        return IdCondPago;
    }

    public void setIdCondPago(CondicionPago idCondPago) {
        IdCondPago = idCondPago;
    }

    public Usuario getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        IdUsuario = idUsuario;
    }

    public Moneda getIdMoneda() {
        return IdMoneda;
    }

    public void setIdMoneda(Moneda idMoneda) {
        IdMoneda = idMoneda;
    }

    public Moneda getIdMoneBase() {
        return IdMoneBase;
    }

    public void setIdMoneBase(Moneda idMoneBase) {
        IdMoneBase = idMoneBase;
    }

    public Proveedor getIdProv() {
        return IdProv;
    }

    public void setIdProv(Proveedor idProv) {
        IdProv = idProv;
    }

    public String getNumPediComp() {
        return NumPediComp;
    }

    public void setNumPediComp(String numPediComp) {
        NumPediComp = numPediComp;
    }

    public String getNumSeri() {
        return NumSeri;
    }

    public void setNumSeri(String numSeri) {
        NumSeri = numSeri;
    }

    public LocalDate getFecEmis() {
        return FecEmis;
    }

    public void setFecEmis(LocalDate fecEmis) {
        FecEmis = fecEmis;
    }

    public LocalDate getFecExpi() {
        return FecExpi;
    }

    public void setFecExpi(LocalDate fecExpi) {
        FecExpi = fecExpi;
    }

    public float getFacCamb() {
        return FacCamb;
    }

    public void setFacCamb(float facCamb) {
        FacCamb = facCamb;
    }

    public float getFacCambBase() {
        return FacCambBase;
    }

    public void setFacCambBase(float facCambBase) {
        FacCambBase = facCambBase;
    }

    public float getPorIgv() {
        return PorIgv;
    }

    public void setPorIgv(float porIgv) {
        PorIgv = porIgv;
    }

    public float getImpIgv() {
        return ImpIgv;
    }

    public void setImpIgv(float impIgv) {
        ImpIgv = impIgv;
    }

    public float getImpTota() {
        return ImpTota;
    }

    public void setImpTota(float impTota) {
        ImpTota = impTota;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getAtencion() {
        return Atencion;
    }

    public void setAtencion(String atencion) {
        Atencion = atencion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }




    
}
