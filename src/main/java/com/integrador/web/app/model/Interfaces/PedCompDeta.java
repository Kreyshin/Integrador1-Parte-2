package com.integrador.web.app.model.Interfaces;

public class PedCompDeta {
    private int IdProd;
    private String CodProd;
    private String NomProd;
    private float CostProd;
    private int CanProd;

    public PedCompDeta() {
    }

    public PedCompDeta(int idProd, String codProd, String nomProd, float costProd, int canProd) {
        IdProd = idProd;
        CodProd = codProd;
        NomProd = nomProd;
        CostProd = costProd;
        CanProd = canProd;
    }

    public int getIdProd() {
        return IdProd;
    }

    public void setIdProd(int idProd) {
        IdProd = idProd;
    }

    public String getCodProd() {
        return CodProd;
    }

    public void setCodProd(String codProd) {
        CodProd = codProd;
    }

    public String getNomProd() {
        return NomProd;
    }

    public void setNomProd(String nomProd) {
        NomProd = nomProd;
    }

    public float getCostProd() {
        return CostProd;
    }

    public void setCostProd(float costProd) {
        CostProd = costProd;
    }

    public int getCanProd() {
        return CanProd;
    }

    public void setCanProd(int canProd) {
        CanProd = canProd;
    }

    

}