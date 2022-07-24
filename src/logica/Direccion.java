/*

                 *´¨) 
                ¸.•´ ¸.•´¸.•*´¨) ¸.•*¨) 
                (¸.•´ (¸.•` ¤ 
       .---.     calderon.brandon@correounivalle.edu.co
      /     \                 202125974
      \.@-@./     jose.bucheli@correounivalle.edu.co          
      /`\_/`\                 202125340
     //  _  \\         Ingeniería de sistemas          
    | \     )|_               Profesor
   /`\_`>  <_/ \      Luis Yovany Romo Portilla         
   \__/'---'\__/     
 */

package logica;

/**
 *  CLASE:     Direccion
 *  INTENCION: Representar una direccion de nuestro directorio.
 *  RELACION:  NINGUNA 
 */

public class Direccion {
    private String address;
    private String place;
    
    public Direccion(String address, String place) {
        this.address = address;
        this.place = place; // Las opciones del lugar las proponemos nostros
    }
    
    public String[] getDireccion() {
        String[] information = new String[2]; 
        
        information[0] = address;
        information[1] = place;
        
        return information;
    }
}
