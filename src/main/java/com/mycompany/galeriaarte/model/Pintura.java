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

    public Pintura(String tecnica, String dimensiones, int idObra, String titulo, String autor, LocalDate anioCreacion, double precio, String estado) {
        super(idObra, titulo, autor, anioCreacion, precio, estado);
        this.tecnica = tecnica;
        this.dimensiones = dimensiones;
    }

}
