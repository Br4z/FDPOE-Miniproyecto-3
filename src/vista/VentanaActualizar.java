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
 *  CLASE:     VentanaActualizar
 *  INTENCION: Ser la ventana donde se actualiza un contacto de la "base de datos".
 *  RELACION:  NINGUNA 
 */

public class VentanaActualizar extends JFrame {
    public VentanaActualizar() {
        initializeComponents();        
        setSize(600, 600);
        setTitle("Directorio telefonico - Actualizar contacto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);        
    }

    private void initializeComponents() {
        
    }
}
