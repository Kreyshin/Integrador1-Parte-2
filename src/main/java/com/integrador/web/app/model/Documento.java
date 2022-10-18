package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "Documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDocu")
    private int Id; 

    @Column(name = "DesDocu", length = 50)
    private String DesDocu;
    
    @Column(name = "IndSeri", length = 1)
    private String IndSeri;

    @Column(name = "NumLongCorr")
    private int NumLongCorr;

    @Column(name = "IndCorrAuto", length = 1)
    private String IndCorrAuto;

    @Column(name = "NumUltiCorr")
    private int NumUltiCorr;

    @Column(name = "Estado", length = 4)
    private String Estado;

    public Documento() {
    }

    public Documento(int id, String desDocu, String indSeri, int numLongCorr, String indCorrAuto, int numUltiCorr,
            String estado) {
        Id = id;
        DesDocu = desDocu;
        IndSeri = indSeri;
        NumLongCorr = numLongCorr;
        IndCorrAuto = indCorrAuto;
        NumUltiCorr = numUltiCorr;
        Estado = estado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDesDocu() {
        return DesDocu;
    }

    public void setDesDocu(String desDocu) {
        DesDocu = desDocu;
    }

    public String getIndSeri() {
        return IndSeri;
    }

    public void setIndSeri(String indSeri) {
        IndSeri = indSeri;
    }

    public int getNumLongCorr() {
        return NumLongCorr;
    }

    public void setNumLongCorr(int numLongCorr) {
        NumLongCorr = numLongCorr;
    }

    public String getIndCorrAuto() {
        return IndCorrAuto;
    }

    public void setIndCorrAuto(String indCorrAuto) {
        IndCorrAuto = indCorrAuto;
    }

    public int getNumUltiCorr() {
        return NumUltiCorr;
    }

    public void setNumUltiCorr(int numUltiCorr) {
        NumUltiCorr = numUltiCorr;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
