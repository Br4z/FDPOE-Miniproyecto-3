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

import java.util.Calendar;

/**
 *  CLASE:     Contacto
 *  INTENCION: Representar un contacto en nuestra guia telefonica
 *  RELACION:  NINGUNA 
 */

public class Contacto {
    private int position; // Esta va a ser una de nuestras variables de control
    private static int nextPosition = 1;
    private int type; // 1 - Estudiante 2 - Empleado 3 - Profesor
    private String names;
    private String lastName;
    private Calendar birth; // Podria ser final, pero se pueden equivocar en su digitacion
    private String[] direction = new String[2]; // El primer elemento va a ser la direccion en si, y
    // el segundo el lugar asociado
    private int[] telephone = new int[2]; // El primer elemento va a ser el numero en si, y
    // el segundo el lugar asociado

    public Contacto(int type, String names, String lastName, Calendar birth, String[] direction, int[] telephone) {
        position = nextPosition;
        nextPosition++;
        this.type = type;
        this.names = names;
        this.lastName = lastName;
        this.birth = birth;
        this.direction = direction;
        this.telephone = telephone;
    }
    
}
