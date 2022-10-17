package com.integrador.web.app.model;


import javax.persistence.*;

@Entity
@Table(name = "CondicionPago")
public class CondicionPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCondPago")
    private int Id;

    @Column(name = "DesCondPago" )
    private String DesCondPago;

    @Column(name = "NumDias")
    private int NumDias;

    public CondicionPago() {
    }

    public CondicionPago(int id, String desCondPago, int numDias) {
        Id = id;
        DesCondPago = desCondPago;
        NumDias = numDias;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDesCondPago() {
        return DesCondPago;
    }

    public void setDesCondPago(String desCondPago) {
        DesCondPago = desCondPago;
    }

    public int getNumDias() {
        return NumDias;
    }

    public void setNumDias(int numDias) {
        NumDias = numDias;
    }
}
