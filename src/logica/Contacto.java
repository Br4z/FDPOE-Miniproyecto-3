/*
                 *´¨) 
                ¸.•´ ¸.•´¸.•*´¨) ¸.•*¨) 
                (¸.•´ (¸.•` ¤ Brandon Calderón Prieto  
       .---.         
      /     \   calderon.brandon@correounivalle.edu.co     
      \.@-@./               
      /`\_/`\               202125974
     //  _  \\        
    | \     )|_        Ingeniería de sistemas
   /`\_`>  <_/ \
   \__/'---'\__/
 */

package logica;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *  CLASE:     Contacto
 *  INTENCION: Representar un contacto en nuestra guia telefonica
 *  RELACION:  NINGUNA 
 */

public class Contacto {
    private int position; // Esta va a ser una de nuestras variables de control
    private static int nextPosition = 1;
    private String type; // Estudiante - Empleado - Profesor
    private String names;
    private String lastName;
    private Calendar birth; // Podria ser final, pero se pueden equivocar en su digitacion
    private ArrayList<Direccion> directions;
    private ArrayList<Telefono> phones;

    public Contacto(String type, String names, String lastName, Calendar birth, ArrayList<Direccion> directions, ArrayList<Telefono> phones) {
        position = nextPosition;
        nextPosition++;
        this.type = type;
        this.names = names;
        this.lastName = lastName;
        this.birth = birth;
        this.directions = directions;
        this.phones = phones;
    }
    
}
