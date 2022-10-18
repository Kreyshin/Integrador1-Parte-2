package com.integrador.web.app.model;

import javax.persistence.*;

@Entity
@Table(name = "DocumentoSerie")
public class DocumentoSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDocuSeri")
    private int Id;

    @Column(name = "NumSeri")
    private String NumSeri;

    @Column(name = "DesSeri")
    private String DesSeri;

    @Column(name = "IndCorrAuto")
    private String IndCorrAuto;

    @Column(name = "NumUltiCorr")
    private int NumUltiCorr;

    @ManyToOne
    private Documento documento;

    public DocumentoSerie() {
    }

    public DocumentoSerie(int id, String numSeri, String desSeri, String indCorrAuto, int numUltiCorr,
            Documento documento) {
        Id = id;
        NumSeri = numSeri;
        DesSeri = desSeri;
        IndCorrAuto = indCorrAuto;
        NumUltiCorr = numUltiCorr;
        this.documento = documento;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNumSeri() {
        return NumSeri;
    }

    public void setNumSeri(String numSeri) {
        NumSeri = numSeri;
    }

    public String getDesSeri() {
        return DesSeri;
    }

    public void setDesSeri(String desSeri) {
        DesSeri = desSeri;
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

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    
    

}
