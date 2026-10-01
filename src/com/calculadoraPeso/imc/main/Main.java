/**
 *
 * @author Guillermo Eugui Sánchez
 */

package com.calculadoraPeso.imc.main;

import com.calculadoraPeso.imc.controller.IMCController;
import com.calculadoraPeso.imc.view.IMCVista;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Calculadora de IMC");
        IMCVista vista = new IMCVista();
        IMCController controlador = new IMCController(vista);
        ventana.setContentPane(vista);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    }
