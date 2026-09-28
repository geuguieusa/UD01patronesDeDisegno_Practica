package com.calculadoraPeso.imc.model;

/**
 *
 * @author Guillermo Eugui Sánchez
 */
public class CalculadoraIMC {
    
    public double calcular(double peso, double altura) {
        return peso / (altura * altura);
    }

    public String clasificar(double imc) {
        if (imc < 18.5) {
            return "Bajo Peso";
        } else if (imc < 25.0) {
            return "Peso Normal";
        } else if (imc < 30.0) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}