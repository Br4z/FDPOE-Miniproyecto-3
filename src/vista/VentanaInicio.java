/*

                 *´¨) 
                ¸.•´ ¸.•´¸.•*´¨) ¸.•*¨) 
                (¸.•´ (¸.•` ¤ 
       .---.     calderon.brandon@correounivalle.edu.co
      /     \                 202125974
      \.@-@./               
      /`\_/`\                 
     //  _  \\         Ingeniería de sistemas          
    | \     )|_               Profesor
   /`\_`>  <_/ \      Luis Yovany Romo Portilla         
   \__/'---'\__/     
 */

package vista;

import javax.swing.*;

/**
 *  CLASE:     VentanaInicio
 *  INTENCION: Ser la ventana donde se presentan las opciones del directiorio telefonico.
 *  RELACION:  NINGUNA 
 */

public class VentanaInicio extends JFrame {    
    public VentanaInicio() {
        initializeComponents();        
        setSize(300, 300);
        setTitle("Directorio telefonico - Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);        
    }

    private void initializeComponents() {
        
    }
}
