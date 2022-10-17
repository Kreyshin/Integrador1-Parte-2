package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEmpresa")
    private int id;
    private String NomEmpr;
    private String numRucs;
    private String DesDire;
    private String NumTel1;

    public Empresa() {
    }

    public Empresa(int id, String nomEmpr, String numRucs, String desDire, String numTel1) {
        this.id = id;
        NomEmpr = nomEmpr;
        this.numRucs = numRucs;
        DesDire = desDire;
        NumTel1 = numTel1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEmpr() {
        return NomEmpr;
    }

    public void setNomEmpr(String nomEmpr) {
        NomEmpr = nomEmpr;
    }

    public String getNumRucs() {
        return numRucs;
    }

    public void setNumRucs(String numRucs) {
        this.numRucs = numRucs;
    }

    public String getDesDire() {
        return DesDire;
    }

    public void setDesDire(String desDire) {
        DesDire = desDire;
    }

    public String getNumTel1() {
        return NumTel1;
    }

    public void setNumTel1(String numTel1) {
        NumTel1 = numTel1;
    }
}
