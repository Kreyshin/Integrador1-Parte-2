package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMarca")
    private int Id;
    private String DesMarc;
    private String Estado;

    public Marca() {
    }

    public Marca(int id, String desMarc, String estado) {
        Id = id;
        DesMarc = desMarc;
        Estado = estado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDesMarc() {
        return DesMarc;
    }

    public void setDesMarc(String desMarc) {
        DesMarc = desMarc;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
    
    
}
