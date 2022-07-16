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

import javax.swing.JFrame;

/**
 *  CLASE:     VentanaListar
 *  INTENCION: Ser la ventana donde se muestra el listado de los contactos guardados.
 *  RELACION:  NINGUNA 
 */

public class VentanaListar extends JFrame {
    public VentanaListar() {
        initializeComponents();        
        setSize(300, 300);
        setTitle("Directorio telefonico - Listado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);        
    }

    private void initializeComponents() {
        
    }
}
