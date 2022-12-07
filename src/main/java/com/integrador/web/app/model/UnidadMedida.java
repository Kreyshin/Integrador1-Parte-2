package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "UnidadMedida")
public class UnidadMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUnidadMedida")
    private int Id;

    private String DesUnme;

    private String Estado;

    public UnidadMedida() {
    }

    public UnidadMedida(int id, String desUnme, String estado) {
        Id = id;
        DesUnme = desUnme;
        Estado = estado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDesUnme() {
        return DesUnme;
    }

    public void setDesUnme(String desUnme) {
        DesUnme = desUnme;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    

}
