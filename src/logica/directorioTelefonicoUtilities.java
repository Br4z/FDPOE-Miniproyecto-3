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
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *  CLASE:     directorioTelefonicoUtilities
  INTENCION: Encargarse de las operaciones de nuestra guia telefonica
  RELACION:  NINGUNA 
 */

public class directorioTelefonicoUtilities {
    ArrayList<Contacto>  contactos = new ArrayList();
    File data = new File("src/contactos.txt");
    
    public directorioTelefonicoUtilities() {
        if(crear()) loadContactos();
    }
    
    public boolean crear() {
        if(data.exists()) { // Si no existe, entonces lo crea
            try {
                data.createNewFile();
            } catch (IOException ex) {
                System.out.println("No se pudo crear el archivo \"contactos.txt\"");
            }          
        }
        return data.exists();
    }
    
    public void loadContactos() {
        
        try { 
            FileReader fileReader = new FileReader(data);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            StringTokenizer stringTokenizer; 
            
            while ((line = bufferedReader.readLine()) != null) { // Cuando lee avanza a la siguiente linea
                System.out.println(line);
                stringTokenizer = new StringTokenizer(line, ";"); // Los delimitadores entre campos son ";"
                
                while(stringTokenizer.hasMoreTokens()) {
                    String field = stringTokenizer.nextToken();
                }
            }            
            
            fileReader.close(); // Dejamos de usar el archivo ("lo cerramos")
        } catch (FileNotFoundException ex) {
            System.out.println("Ha ocurrido un error al intentar leer el archivo \"contactos.txt\"");
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error al intentar leer las lineas del archivo \"contactos.txt\"");
        }       
    }
    
    public void addAContacto(Contacto contacto) {
        
    }
    
    public static void deleteAContacto(int position) {
        
    }
    
    public static void updateAContacto(int position) {
        
    }
}
