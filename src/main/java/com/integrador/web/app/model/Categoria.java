package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCategoria")
    private int Id;

    private String DesCate;
    private String Estado;
    public Categoria() {
    }
    public Categoria(int id, String desCate, String estado) {
        Id = id;
        DesCate = desCate;
        Estado = estado;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getDesCate() {
        return DesCate;
    }
    public void setDesCate(String desCate) {
        DesCate = desCate;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }

    
}
