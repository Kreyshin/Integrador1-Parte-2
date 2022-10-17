package com.integrador.web.app.model;


import javax.persistence.*;

@Entity
@Table( name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRol")
    private int Id;
    @Column(name = "DesRol")
    private String DesRol;

    public Rol() {
    }

    public Rol(int id, String desRol) {
        Id = id;
        DesRol = desRol;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDesRol() {
        return DesRol;
    }

    public void setDesRol(String desRol) {
        DesRol = desRol;
    }
}
