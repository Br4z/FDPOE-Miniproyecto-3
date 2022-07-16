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
 *  CLASE:     VentanaEliminar
 *  INTENCION: Ser la ventan donde se puede eliminar un contacto.
 *  RELACION:  NINGUNA 
 */

public class VentanaEliminar extends JFrame {
    public VentanaEliminar() {
        initializeComponents();        
        setSize(600, 600);
        setTitle("Directorio telefonico - Eliminar contacto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);        
    }

    private void initializeComponents() {
        
    }
}
