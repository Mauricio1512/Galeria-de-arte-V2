/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.galeriaarte.validator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author dani_
 */
public abstract class ConversorFormulario {

    public static Integer convertirEntero(String valor) {
            return Integer.parseInt(valor.trim());
    }
    
    public static double convertirDouble (String valor){
            return Double.parseDouble(valor.trim());
    }
    
    public static LocalDate convertirFecha(String valor) {
            return LocalDate.parse(valor.trim()); // yyyy-MM-dd
        }
    }

