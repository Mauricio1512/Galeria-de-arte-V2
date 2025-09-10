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
public abstract class ObraArte {

    private int idObra;
    private String titulo;
    private String autor;
    private LocalDate anioCreacion;
    private double precio;
    private String estado;

    //Constructor
    public ObraArte(int idObra, String titulo, String autor,
            LocalDate anioCreacion, double precio, String estado) {
        this.idObra = idObra;
        this.titulo = titulo;
        this.autor = autor;
        this.anioCreacion = anioCreacion;
        setPrecio(precio);
        setEstado(estado);
    }

    public ObraArte() {
    }

    ;
    
    //Getters and Setters
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getAnioCreacion() {
        return this.anioCreacion;
    }

    public void setAnioCreacion(LocalDate anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        if (estado.equalsIgnoreCase("Activo") || estado.equalsIgnoreCase("Inactivo")) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("Estado inválido. Solo se permite 'Activo' o 'Inactivo'.");
        }
    }

}
