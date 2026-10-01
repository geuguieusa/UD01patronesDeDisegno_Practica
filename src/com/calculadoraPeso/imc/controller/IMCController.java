package com.calculadoraPeso.imc.controller;

/**
 *
 * @author Guillermo Eugui Sánchez
 */


import com.calculadoraPeso.imc.model.CalculadoraIMC;
import com.calculadoraPeso.imc.view.IMCVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.calculadoraPeso.imc.model.CalculadoraIMC;

public class IMCController {
    private final CalculadoraIMC calculadora = new CalculadoraIMC();

    private final JTextField txtPeso;
    private final JTextField txtAltura;
    private final JButton btnCalcular;
    private final JLabel lblResultado;
    private final JLabel lblClasificacion;

    public IMCController(IMCVista vista) {
        lblResultado = vista.getLblResultado();
        lblClasificacion = vista.getLblClasificacion();
        txtPeso = vista.getTxtPeso();
        txtAltura = vista.getTxtAltura();
        btnCalcular = vista.getBtnCalcular();

        this.btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        String textoPeso = txtPeso.getText().trim().replace(',', '.');
        String textoAltura = txtAltura.getText().trim().replace(',', '.');

        double peso;
        double altura;

        try {
            peso = Double.parseDouble(textoPeso);
            altura = Double.parseDouble(textoAltura);
            
        } catch (NumberFormatException nfn) {
            lblClasificacion.setText("Error: Introduce solo números válidos");
            lblResultado.setText("");
            return;
        }

        double imc = calculadora.calcular(peso, altura);
        String clasificacion = calculadora.clasificar(imc);

        lblResultado.setText(String.format("Tu IMC es: %.2f", imc));
        lblClasificacion.setText("Clasificación: " + clasificacion);
    }
}
