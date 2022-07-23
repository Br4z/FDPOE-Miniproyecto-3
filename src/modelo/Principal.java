/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.swing.JFrame;
import vista.VentanaManipularContactos;


/**
 *
 * @author jose9
 */
public class Principal {
    public static void main(String[] args) {
        VentanaManipularContactos ventana = new VentanaManipularContactos();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}
