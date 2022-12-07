package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProveedor")
    private int Id;

    private String NomProv;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_cond_pago", nullable=false)
    private CondicionPago IdCondPago;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_moneda", nullable=false)
    private Moneda IdMoneda;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_tipo_proveedor", nullable=false)
    private TipoProveedor IdTipoProveedor;

    private String DesRazoSoci;
    private String NumRucs;
    private String ApePate;
    private String ApeMate;
    private String PriNomb;
    private String SegNomb;
    private String TipDocuIden;
    private String NumDocuIden;
    private String DesMail;
    private String Estado;
    private String TipPers;

    
    public Proveedor() {
    }


    public Proveedor(int id, String nomProv, CondicionPago idCondPago, Moneda idMoneda, TipoProveedor idTipoProveedor,
            String desRazoSoci, String numRucs, String apePate, String apeMate, String priNomb, String segNomb,
            String tipDocuIden, String numDocuIden, String desMail, String estado, String tipPers) {
        Id = id;
        NomProv = nomProv;
        IdCondPago = idCondPago;
        IdMoneda = idMoneda;
        IdTipoProveedor = idTipoProveedor;
        DesRazoSoci = desRazoSoci;
        NumRucs = numRucs;
        ApePate = apePate;
        ApeMate = apeMate;
        PriNomb = priNomb;
        SegNomb = segNomb;
        TipDocuIden = tipDocuIden;
        NumDocuIden = numDocuIden;
        DesMail = desMail;
        Estado = estado;
        TipPers = tipPers;
    }


    public int getId() {
        return Id;
    }


    public void setId(int id) {
        Id = id;
    }


    public String getNomProv() {
        return NomProv;
    }


    public void setNomProv(String nomProv) {
        NomProv = nomProv;
    }


    public CondicionPago getIdCondPago() {
        return IdCondPago;
    }


    public void setIdCondPago(CondicionPago idCondPago) {
        IdCondPago = idCondPago;
    }


    public Moneda getIdMoneda() {
        return IdMoneda;
    }


    public void setIdMoneda(Moneda idMoneda) {
        IdMoneda = idMoneda;
    }


    public TipoProveedor getIdTipoProveedor() {
        return IdTipoProveedor;
    }


    public void setIdTipoProveedor(TipoProveedor idTipoProveedor) {
        IdTipoProveedor = idTipoProveedor;
    }


    public String getDesRazoSoci() {
        return DesRazoSoci;
    }


    public void setDesRazoSoci(String desRazoSoci) {
        DesRazoSoci = desRazoSoci;
    }


    public String getNumRucs() {
        return NumRucs;
    }


    public void setNumRucs(String numRucs) {
        NumRucs = numRucs;
    }


    public String getApePate() {
        return ApePate;
    }


    public void setApePate(String apePate) {
        ApePate = apePate;
    }


    public String getApeMate() {
        return ApeMate;
    }


    public void setApeMate(String apeMate) {
        ApeMate = apeMate;
    }


    public String getPriNomb() {
        return PriNomb;
    }


    public void setPriNomb(String priNomb) {
        PriNomb = priNomb;
    }


    public String getSegNomb() {
        return SegNomb;
    }


    public void setSegNomb(String segNomb) {
        SegNomb = segNomb;
    }


    public String getTipDocuIden() {
        return TipDocuIden;
    }


    public void setTipDocuIden(String tipDocuIden) {
        TipDocuIden = tipDocuIden;
    }


    public String getNumDocuIden() {
        return NumDocuIden;
    }


    public void setNumDocuIden(String numDocuIden) {
        NumDocuIden = numDocuIden;
    }


    public String getDesMail() {
        return DesMail;
    }


    public void setDesMail(String desMail) {
        DesMail = desMail;
    }


    public String getEstado() {
        return Estado;
    }


    public void setEstado(String estado) {
        Estado = estado;
    }


    public String getTipPers() {
        return TipPers;
    }


    public void setTipPers(String tipPers) {
        TipPers = tipPers;
    }

    
}
