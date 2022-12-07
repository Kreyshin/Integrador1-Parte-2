package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "TipoProveedor")
public class TipoProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoProveedor")
    private int Id;
    private String DesTipoProv;
    private String Estado;
    
    public TipoProveedor() {
    }

    public TipoProveedor(int id, String desTipoProv, String estado) {
        Id = id;
        DesTipoProv = desTipoProv;
        Estado = estado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDesTipoProv() {
        return DesTipoProv;
    }

    public void setDesTipoProv(String desTipoProv) {
        DesTipoProv = desTipoProv;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    


}
