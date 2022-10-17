package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "TipoProveedor")
public class TipoProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoProveedor")
    private int Id;

}
