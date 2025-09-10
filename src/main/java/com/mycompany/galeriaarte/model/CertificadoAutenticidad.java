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
public class CertificadoAutenticidad {

    private String numeroCertificado;
    private LocalDate fechaEmision;
    private String entidadEmisora;

    public CertificadoAutenticidad(String numeroCertificado, LocalDate fechaEmision, String entidadEmisora) {
        this.numeroCertificado = numeroCertificado;
        this.fechaEmision = fechaEmision;
        this.entidadEmisora = entidadEmisora;
    }

    public String getNumeroCertificado() {
        return numeroCertificado;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public String getEntidadEmisora() {
        return entidadEmisora;
    }

    @Override
    public String toString() {
        return "Certificado N°: " + numeroCertificado
                + ", emitido por: " + entidadEmisora
                + " en fecha: " + fechaEmision;
    }
}
