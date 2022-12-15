package com.integrador.web.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PedidoCompraDetalle")
public class PedCompraDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPediCompDeta")
    private int IdPediCompDeta;

    @Column(name = "NumSecu")
    private int NumSecu;

    @ManyToOne(optional = false)
    @JoinColumn(name="IdPediCompCabe", nullable=false)
    private PedCompraCabecera IdPediCompCabe;

    @ManyToOne(optional = true)
    @JoinColumn(name="IdMoviInveCabe", nullable=true)
    private MovimientoCabecera IdMoviInveCabe;

    @ManyToOne(optional = true)
    @JoinColumn(name="IdDocu", nullable=true)
    private Documento IdDocu;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="IdEmpresa", nullable=false)
    private Empresa IdEmpresa;

    @ManyToOne(optional = false)
    @JoinColumn(name="IdProducto", nullable=false)
    private Producto IdProducto;

    @Column(name = "CanComp")
    private float CanComp;

    @Column(name = "CanAlma")
    private float CanAlma;

    @Column(name = "CosUnit")
    private float CosUnit;

    @Column(name = "CanReci")
    private float CanReci;

    @Column(name = "CanReciAlma")
    private float CanReciAlma;

    @Column(name = "IndAten")
    private String IndAten;

    public PedCompraDetalle() {
    }

    public PedCompraDetalle(int idPediCompDeta, int numSecu, PedCompraCabecera idPediCompCabe,
            MovimientoCabecera idMoviInveCabe, Documento idDocu, Empresa idEmpresa, Producto idProducto, float canComp,
            float canAlma, float cosUnit, float canReci, float canReciAlma, String indAten) {
        IdPediCompDeta = idPediCompDeta;
        NumSecu = numSecu;
        IdPediCompCabe = idPediCompCabe;
        IdMoviInveCabe = idMoviInveCabe;
        IdDocu = idDocu;
        IdEmpresa = idEmpresa;
        IdProducto = idProducto;
        CanComp = canComp;
        CanAlma = canAlma;
        CosUnit = cosUnit;
        CanReci = canReci;
        CanReciAlma = canReciAlma;
        IndAten = indAten;
    }

    public int getIdPediCompDeta() {
        return IdPediCompDeta;
    }

    public void setIdPediCompDeta(int idPediCompDeta) {
        IdPediCompDeta = idPediCompDeta;
    }

    public int getNumSecu() {
        return NumSecu;
    }

    public void setNumSecu(int numSecu) {
        NumSecu = numSecu;
    }

    public PedCompraCabecera getIdPediCompCabe() {
        return IdPediCompCabe;
    }

    public void setIdPediCompCabe(PedCompraCabecera idPediCompCabe) {
        IdPediCompCabe = idPediCompCabe;
    }

    public MovimientoCabecera getIdMoviInveCabe() {
        return IdMoviInveCabe;
    }

    public void setIdMoviInveCabe(MovimientoCabecera idMoviInveCabe) {
        IdMoviInveCabe = idMoviInveCabe;
    }

    public Documento getIdDocu() {
        return IdDocu;
    }

    public void setIdDocu(Documento idDocu) {
        IdDocu = idDocu;
    }

    public Empresa getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        IdEmpresa = idEmpresa;
    }

    public Producto getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Producto idProducto) {
        IdProducto = idProducto;
    }

    public float getCanComp() {
        return CanComp;
    }

    public void setCanComp(float canComp) {
        CanComp = canComp;
    }

    public float getCanAlma() {
        return CanAlma;
    }

    public void setCanAlma(float canAlma) {
        CanAlma = canAlma;
    }

    public float getCosUnit() {
        return CosUnit;
    }

    public void setCosUnit(float cosUnit) {
        CosUnit = cosUnit;
    }

    public float getCanReci() {
        return CanReci;
    }

    public void setCanReci(float canReci) {
        CanReci = canReci;
    }

    public float getCanReciAlma() {
        return CanReciAlma;
    }

    public void setCanReciAlma(float canReciAlma) {
        CanReciAlma = canReciAlma;
    }

    public String getIndAten() {
        return IndAten;
    }

    public void setIndAten(String indAten) {
        IndAten = indAten;
    }

    

}
