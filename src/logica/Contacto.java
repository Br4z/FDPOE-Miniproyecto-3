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

/**
 *  CLASE:     Contacto
 *  INTENCION: Representar un contacto en la guia telefonica
 *  RELACION:  NINGUNA 
 */

public class Contacto {
    private int position; // Esta va a ser una de nuestras variables de control  
    private String[] ID = new String[2]; // [0] - Tipo / [1] - Numero
    private String role; // Estudiante/Empleado/Profesor
    private String name;
    private String lastName;
    private String birth; // Podria ser final, pero se pueden equivocar en su digitacion
    private ArrayList<String> addresses;
    private ArrayList<Telefono> telephones;

    public Contacto(String[] ID, String role, String name, String lastName, String birth, ArrayList<String> directions, ArrayList<Telefono> telephones) {
        this.ID = ID;
        this.role = role;
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.addresses = directions;
        this.telephones = telephones;
    }
    
    public String[] getID() {
        return ID;
    }

    public int getPosition() {
        return position;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirth() {
        return birth;
    }

    public ArrayList<String> getAddresses() {
        return addresses;
    }

    public ArrayList<Telefono> getTelephones() {
        return telephones;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }
    public void decreasePosition() {
        position--;
    }
    

    
}
