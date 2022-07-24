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

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  CLASE:     Utilities
  INTENCION: Encargarse de las operaciones de nuestra guia telefonica
  RELACION:  NINGUNA 
 */

public class Utilities {
    private int nextPosition = 1;
    private ArrayList<Contacto>  contactos = new ArrayList();
    private File data = new File("src/contactos.txt");
    
    public Utilities() {
        if(crear()) loadContactos();
    }
    
    public boolean crear() {
        if(!data.exists()) { // Si no existe, entonces lo crea
            try {
                data.createNewFile();
            } catch (IOException ex) {
                System.out.println("No se pudo crear el archivo \"contactos.txt\"");
            }          
        }
        return data.exists();
    }
    
    public void loadContactos() {
        File data = new File("src/contactos.txt");
        
        try {
            ArrayList<Telefono> telephones = new ArrayList<>();
            ArrayList<String> information = new ArrayList<>(); // Cada contacto tiene 8 campos
            FileReader fileReader = new FileReader(data);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            StringTokenizer stringTokenizer;
            StringTokenizer stringTokenizer2;
            int counter;
            
            while ((line = bufferedReader.readLine()) != null) { // Cuando lee avanza a la siguiente linea         
                stringTokenizer = new StringTokenizer(line, ";"); // Los delimitadores entre campos son ";"
                
                while(stringTokenizer.hasMoreTokens()) {
                    counter = 0;
                    String field = stringTokenizer.nextToken();                  
                    stringTokenizer2 = new StringTokenizer(field, ":");
                    
                    while(stringTokenizer2.hasMoreTokens()) {
                        counter++;
                        String fielInformation = stringTokenizer2.nextToken();
                        if(counter % 2 == 0) { // Despues del titulo viene la informacion
                            information.add(fielInformation);
                        }
                    }
                    
                }
            }
      
            for(int i = 0; i < (information.size() / 8); i++) { // 8 campos son los que tiene un contacto
                int position;
                String[] ID = new String[2];
                String role; 
                String name;
                String lastName;
                String birth; 
                ArrayList<String> directions = new ArrayList<>();

                int contactNumber = i * 8;
                position = Integer.parseInt(information.get(contactNumber + 0));
                stringTokenizer = new StringTokenizer(information.get(contactNumber + 1), ",");
                ID[0] = stringTokenizer.nextToken();
                ID[1] = stringTokenizer.nextToken();
                role = information.get(contactNumber + 2);
                name = information.get(contactNumber + 3);
                lastName = information.get(contactNumber + 4);
                birth = information.get(contactNumber + 5);
                
                stringTokenizer = new StringTokenizer(information.get(contactNumber + 6), ",");
                
                for(int j = 0; j < (stringTokenizer.countTokens() / 2); j++) {
                    long number = Long.parseLong(stringTokenizer.nextToken());
                    String place = stringTokenizer.nextToken();
                    Telefono telephone = new Telefono(number, place);
                    telephones.add(telephone);
                }
                
                stringTokenizer = new StringTokenizer(information.get(contactNumber + 7), ",");
                
                while(stringTokenizer.hasMoreTokens()) {
                    String direction = stringTokenizer.nextToken();
                    directions.add(direction);
                }
                Contacto contact = new Contacto(ID, role, name, lastName, birth, directions, telephones);
                contact.setPosition(position);
                contactos.add(contact);
                System.out.println(position);
                System.out.println(Arrays.toString(ID));
                System.out.println(role);
                System.out.println(name);
                System.out.println(lastName);
                System.out.println(birth);
                System.out.println(directions);
            }           
            fileReader.close(); // Dejamos de usar el archivo ("lo cerramos")
        } catch (FileNotFoundException ex) {
            System.out.println("Ha ocurrido un error al intentar leer el archivo \"contactos.txt\"");
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error al intentar leer las lineas del archivo \"contactos.txt\"");
        }          
    }
    
    public void addContacto(Contacto contacto) {
        contacto.setPosition(nextPosition);
        nextPosition++;
        contactos.add(contacto);
    }
    
    public void deleteContacto(int position) {
        for(int i = position - 1; i < contactos.size(); i++) {
            contactos.get(i).decreasePosition();
            
        }
        nextPosition--;
    }
    
    public void editContacto(int position, Contacto contacto) {
        contactos.add(position - 1, contacto);
    }
    
    public void writeContactos() {
        try {
            FileWriter fileWriter = new FileWriter(data, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            for(Contacto contacto:contactos) {
                String line = "Posicion:";
                line += contacto.getPosition();
                line += ";ID:";
                line += contacto.getID()[0] + "," + contacto.getID()[1]; // Tipo - Numero
                line += ";Rol:";
                line += contacto.getRole();                
                line += ";Nombres:";
                line += contacto.getName();
                line += ";Apellidos:";
                line += contacto.getLastName();
                line += ";Nacimiento:";
                line += contacto.getBirth();
                line += ";Telefonos:";
                
                ArrayList<Telefono> telephones = contacto.getTelephones();
                for(int i = 0; i < telephones.size(); i++) {
                    String[] telephone = telephones.get(i).getTelefono();
                    
                    if(i == telephones.size() - 1) {// Ultimo telefono
                        line += telephone[0] + "," + telephone[1];
                    } else {
                       line += telephone[0] + "," + telephone[1] + ","; // Numero - Lugar 
                    }                    
                }
                
                line += ";Direcciones:";
                ArrayList<String> directions = contacto.getAddresses();
                for(int i = 0; i < directions.size(); i++) {
                    if(i == directions.size() - 1) {// Ultima direccion
                        line += directions.get(i);
                    } else {
                        line += directions.get(i) + ",";
                    }
                }
                printWriter.println(line);
            }
            
            fileWriter.close();
        } catch(IOException e) {
            System.out.println("Ha ocurrido un error al tratar de escribir en el archivo \"contactos.txt\"");
        }
    }
    
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
}
