package com.calculadoraPeso.imc.controller;

/**
 *
 * @author Guillermo Eugui Sánchez
 */

import com.calculadoraPeso.imc.model.CalculadoraIMC;
import com.calculadoraPeso.imc.view.IMCVista;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IMCController {

    private final CalculadoraIMC calculadora = new CalculadoraIMC();

    private final JTextField txtPeso;
    private final JTextField txtAltura;
    private final JLabel lblClasificacion;
    private final JButton btnCalcular;
    private final JLabel lblResultado;

    public IMCController(IMCVista vista) {
        this.txtPeso = vista.getTxtPeso();
        this.txtAltura = vista.getTxtAltura();
        this.lblResultado = vista.getLblResultado();
        this.lblClasificacion = vista.getLblClasificacion();
        this.btnCalcular = vista.getBtnCalcular();
        this.btnCalcular.addActionListener(e -> calcularIMC());
    }

    private void calcularIMC() {
        String textoPeso = txtPeso.getText().trim().replace(',', '.');
        String textoAltura = txtAltura.getText().trim().replace(',', '.');

        double peso;
        double altura;

        try {
             peso = Double.parseDouble(textoPeso);
            altura = Double.parseDouble(textoAltura);
            }catch (NumberFormatException ex) {
            escribirError("Error: Datos inválidos");
            return;
        }
         if (peso <= 0 || altura <= 0) {
            escribirError("Error: Peso y altura deben ser mayores que 0");
            return;
            }
         
        double imc = calculadora.calcular(peso, altura);
        String clasificacion = calculadora.clasificar(imc);
        
        lblResultado.setText(String.format("Tu IMC es: %.2f", imc));
        lblClasificacion.setText("Clasificación: " + clasificacion);        
        }
    
        private void escribirError(String mensaje) {
        lblResultado.setText("");
        lblClasificacion.setText(mensaje);
        }
    }
