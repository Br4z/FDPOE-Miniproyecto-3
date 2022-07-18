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
 *  CLASE:     Direccion
 *  INTENCION: Representar una direccion de nuestro directorio.
 *  RELACION:  NINGUNA 
 */

public class Direccion {
    private String direction;
    private String place;
    
    public Direccion(String direction, String place) {
        this.direction = direction;
        this.place = place; // Las opciones del lugar las proponemos nostros
    }
    
    public String[] getDireccion() {
        String[] information = new String[2]; 
        
        information[0] = direction;
        information[1] = place;
        
        return information;
    }
}
