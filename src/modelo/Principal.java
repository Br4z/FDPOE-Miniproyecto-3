/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.swing.JFrame;
import vista.VentanaInicio;
import vista.VentanaManipularContactos;


/**
 *
 * @author jose9
 */
public class Principal {
    public static void main(String[] args) {
        //VentanaManipularContactos ventana = new VentanaManipularContactos();
        VentanaInicio ventana = new VentanaInicio();
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}
