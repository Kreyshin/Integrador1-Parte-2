package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Almacen")
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAlmacen")
    private int Id;

    private String DesAlma;

    @ManyToOne(optional = false)
    private Empresa empresa;

    @Column(name = "Estado")
    private String Estado;

    private String DesDire;

    public Almacen() {
    }

    public Almacen(int id, String desAlma, Empresa empresa, String estado, String desDire) {
        Id = id;
        DesAlma = desAlma;
        this.empresa = empresa;
        Estado = estado;
        DesDire = desDire;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDesAlma() {
        return DesAlma;
    }

    public void setDesAlma(String desAlma) {
        DesAlma = desAlma;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getDesDire() {
        return DesDire;
    }

    public void setDesDire(String desDire) {
        DesDire = desDire;
    }

    

}
