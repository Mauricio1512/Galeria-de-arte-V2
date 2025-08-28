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
    
    private String material;

    public Escultura(double altura, double volumen, String tipoEscultura, String material, int idObra, String titulo, String autor, LocalDate anioCreacion, double precio, String estado) {
        super(idObra, titulo, autor, anioCreacion, precio, estado);
        this.altura = altura;
        this.volumen = volumen;
        this.tipoEscultura = tipoEscultura;
        this.material = material;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public String getTipoEscultura() {
        return tipoEscultura;
    }

    public void setTipoEscultura(String tipoEscultura) {
        this.tipoEscultura = tipoEscultura;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

package com.mycompany.galeriaarte.model;

public class Escultura extends ObraArte implements IFragilidad 
{

    private String material;
    private double peso;
    private double altura;

    public Escultura(int idObra, String titulo, String autor, String material, double peso, double altura) 
    {
        super(idObra, titulo, autor);
        this.material = material;
        this.peso = peso;
        this.altura = altura;
    }

    public String getMaterial() 
    {
        return material;
    }

    public void setMaterial(String material)
    {
        this.material = material;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) 
    {
        this.peso = peso;
    }

    public double getAltura() 
    {
        return altura;
    }

    public void setAltura(double altura) 
    {
        this.altura = altura;
    }

    @Override
    public double calcularFragilidad() 
    {
   
        return (altura / (peso + 1)) * (material.equalsIgnoreCase("vidrio") ? 2 : 1);
    }

    @Override
    public String toString() 
    {
        return super.toString() + 
               ", Material: " + material +
               ", Peso: " + peso +
               ", Altura: " + altura +
               ", Fragilidad: " + calcularFragilidad();
    }
}
    
    
}
