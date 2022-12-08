package com.integrador.web.app.model;

import javax.persistence.*;


@Entity
@Table(name = "StockActual")
public class StockActual {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @ManyToOne(optional = false)
    @JoinColumn(name="id_producto", nullable=false)
    private Producto IdProducto;

    private double CantActu;

    public StockActual() {
    }

    public StockActual(int id, Producto idProducto, double cantActu) {
        Id = id;
        IdProducto = idProducto;
        CantActu = cantActu;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Producto getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Producto idProducto) {
        IdProducto = idProducto;
    }

    public double getCantActu() {
        return CantActu;
    }

    public void setCantActu(double cantActu) {
        CantActu = cantActu;
    }


    
}