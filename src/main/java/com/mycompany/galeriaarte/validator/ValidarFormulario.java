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
public abstract class ValidarFormulario {

    public static boolean camposObligatoriosVacios(String... campos) {
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean esEnteroValido(String valor) {
        try {
            Integer.parseInt(valor.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esDecimalValido(String... valores) {
        for (String valor : valores) {
            try {
                Double.parseDouble(valor.trim());
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    public static boolean esFechaValida(String valor) {
        try {
            LocalDate.parse(valor.trim()); // usa el formato por defecto yyyy-MM-dd
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }

    }

}
