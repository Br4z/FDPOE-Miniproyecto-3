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
    private String role; // Estudiante/Empleado/Profesor
    private String name;
    private String lastName;
    private Calendar birth; // Podria ser final, pero se pueden equivocar en su digitacion
    private Direccion direction;
    private ArrayList<Telefono> telephones;

    public Contacto(String role, String name, String lastName, Calendar birth, Direccion direction, ArrayList<Telefono> telephones) {
        position = nextPosition;
        nextPosition++;
        this.role = role;
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.direction = direction;
        this.telephones = telephones;
    }
    
}
