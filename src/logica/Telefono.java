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

/**
 *  CLASE:     Telefono
 *  INTENCION: Representar un telefono de nuestro directorio.
 *  RELACION:  NINGUNA 
 */

public class Telefono {
    private int number;
    private String place;
    
    public Telefono(int number, String place) {
        this.number = number;
        this.place = place; // Las opciones del lugar las proponemos nostros
    }
    
    public String[] getTelefono() {
        String[] information = new String[2]; 
        
        information[0] = String.valueOf(number); // Transformamos el numero a String
        information[1] = place;
        
        return information;
    }
}
