/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galeriaarte.model;

import java.time.LocalDate;

/**
 *
 * @author SANTIAGO
 */
public class Pintura extends ObraArte {

    private String tecnica;

    private String dimensiones;

    private CertificadoAutenticidad certificado;

    public Pintura(int idObra, String titulo, String autor, LocalDate anioCreacion, double precio, String estado, String tecnica, String dimensiones) {
        super(idObra, titulo, autor, anioCreacion, precio, estado);
        this.tecnica = tecnica;
        this.dimensiones = dimensiones;
    }

    public CertificadoAutenticidad getCertificado() {
        return certificado;
    }

    public void setCertificado(CertificadoAutenticidad certificado) {
        this.certificado = certificado;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

}
