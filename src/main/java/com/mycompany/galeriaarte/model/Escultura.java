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
public class Escultura extends ObraArte {
    
    private double altura;
    
    private double volumen;
    
    private String tipoEscultura;

    public Escultura(double altura, double volumen, String tipoEscultura, int idObra, String titulo, String autor, LocalDate anioCreacion, double precio, String estado) {
        super(idObra, titulo, autor, anioCreacion, precio, estado);
        this.altura = altura;
        this.volumen = volumen;
        this.tipoEscultura = tipoEscultura;
    }
    
    
    
}
