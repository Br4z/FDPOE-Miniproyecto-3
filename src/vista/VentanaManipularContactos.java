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

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

import logica.*;

/**
 *  CLASE:     VentanaAgregar
 *  INTENCION: Ser la ventana donde se presentan las opciones del directiorio telefonico.
 *  RELACION:  NINGUNA 
 */

public class VentanaManipularContactos extends JFrame {
    private Utilities utilities     = new Utilities();
    private int mode;
    private int position;
    private Color orange            = new Color(254, 177, 57);
    private JPanel pnl1             = new JPanel(new GridLayout(6, 2, 20, 5));  // Va a contener 
    // todos los campos, excepto los telefonos   
    private JLabel lblID            = new JLabel("Identificacion:");
    private JLabel lblBirth         = new JLabel("Fecha de Nacimiento (DD/MM/YYYY):");
    private JLabel lblName          = new JLabel("Nombres:");
    private JLabel lblLastName      = new JLabel("Apellidos:");
    private JLabel lblAddress       = new JLabel("Direccion:");
    private JLabel lblPhone         = new JLabel("Telefono:");
    private JLabel lblRole          = new JLabel("Rol:");
    private JTextField txtID        = new JTextField();
    private JTextField txtName      = new JTextField();
    private JTextField txtLastName  = new JTextField();
    private JComboBox boxID         = new JComboBox();
    private JComboBox boxRole       = new JComboBox();
    private JTextField txtBirth     = new JTextField();
    
    private int height = 210; // Altura a la que empezamos a agregar cosas despues del panel
    private JTextField[] txtAddresses = new JTextField[5];
    private int countAdress = 1; // Empezamos con una direccion y minimamente debe tener uno
    private int adressHeight = 0;
    
    private JTextField[] txtPhones = new JTextField[5];
    private JComboBox[] boxPhones  = new JComboBox[5];
    private int phoneHeight = 0; // Para llevar control de la creacion de los recuadros
    private int countPhone = 1; // Empezamos con un telefono y minimamente debe tener uno
       
    private JButton btnNewAddress = new JButton("+");
    private JButton btnNewPhones  = new JButton("+");
    private JButton btnButton;
    private JButton btnBack       = new JButton("Volver");
       
    private Container ContenedorInfo;
    
    public VentanaManipularContactos(int position) { // Cuando se edita un contacto
        mode = 0;
        initializeComponents();              
        setTitle("Directorio telefonico - Editar contacto");
        this.position = position;
        setInformation();
    }
    
    public VentanaManipularContactos() { // Cuando se agrega un contacto
        mode = 1;
        initializeComponents();              
        setTitle("Directorio telefonico - Agregar contacto");
    }

    private void initializeComponents() {
        setSize(510, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);
        
        pnl1.setBounds(10, 5, 450, 200);
        pnl1.setBackground(null);
        
        boxID.addItem("T.I");
        boxID.addItem("C.C");
        boxID.setBackground(orange);  
        
        boxRole.addItem("Estudiante");
        boxRole.addItem("Profesor");
        boxRole.addItem("Empleado");
        boxRole.setBackground(orange);
               
        txtAddresses[0] = new JTextField();
        
        btnNewAddress.setBackground(orange);
        btnNewAddress.setBounds(460, 200 - 25, 30, 30); // 25 = 30 / 2 + 5
             
        btnNewPhones.setBackground(orange);
        btnNewPhones.setBounds(460, phoneHeight + height, 30, 30);
        
        if(mode == 0) {
            btnButton = new JButton("Editar");
        } else {
            btnButton = new JButton("Agregar");
        }
        
        btnButton.setBounds(50, 550, 100, 50);
        btnBack.setBounds(350, 550, 100, 50);
        
        txtBirth.addActionListener(new actionListener());
        btnButton.addActionListener(new actionListener());
        btnBack.addActionListener(new actionListener());
        btnNewAddress.addActionListener(new actionListener());
        btnNewPhones.addActionListener(new actionListener());       
        
        JPanel pnlID = new JPanel(new GridLayout(1, 2, 10, 5));
        pnlID.setBackground(null);
        pnlID.add(boxID);
        pnlID.add(txtID);
        
        pnl1.add(lblID);
        pnl1.add(pnlID);
        pnl1.add(lblName);
        pnl1.add(txtName);
        pnl1.add(lblLastName);
        pnl1.add(txtLastName);
        pnl1.add(lblBirth);
        pnl1.add(txtBirth);        
        pnl1.add(lblRole);
        pnl1.add(boxRole);      
        pnl1.add(lblAddress);
        pnl1.add(txtAddresses[0]);
        
        lblPhone.setBounds(10, height, 150, 31);
        txtPhones[0] = new JTextField(); // - 1 para la posicion 0
        txtPhones[0].setBounds(310, height, 150, 31);
        boxPhones[0] = new JComboBox();
        boxPhones[0].setBounds(245, height, 65, 31);
        boxPhones[0].setBackground(orange);
        boxPhones[0].addItem("Movil");
        boxPhones[0].addItem("Casa");
        boxPhones[0].addItem("Trabajo");
        boxPhones[0].addItem("Oficina");           
                       
        ContenedorInfo = getContentPane();
        ContenedorInfo.setLayout(null);
        ContenedorInfo.setBackground(new Color(214, 239, 237));
        ContenedorInfo.add(pnl1);
        ContenedorInfo.add(btnButton);
        ContenedorInfo.add(btnBack);
        ContenedorInfo.add(btnNewAddress);
        ContenedorInfo.add(btnNewPhones);
        ContenedorInfo.add(lblPhone);
        ContenedorInfo.add(txtPhones[0]);
        ContenedorInfo.add(boxPhones[0]);
       
        SwingUtilities.updateComponentTreeUI(ContenedorInfo);
    }
    
    private void clearAllFields() {
        txtID.setText("");
        txtName.setText("");
        txtLastName.setText("");
        txtBirth.setText("");
        
        for(int i = 0; i < countPhone; i++) {
            txtPhones[i].setText("");
        }
        
        for(int i = 0; i < countAdress; i++) {
            txtAddresses[i].setText("");
        }
    }
    
    private void createAddressField() {
        if (countAdress<=4) { // Maximo van a ser 5 direcciones por contacto
            txtAddresses[countAdress] = new JTextField();
            txtAddresses[countAdress].setBounds(245, height + adressHeight, 215, 31);
            btnNewAddress.setBounds(460, height + adressHeight, 30, 30);
            
            adressHeight += 35;
            ContenedorInfo.add(txtAddresses[countAdress]);
            countAdress += 1;

            movePhones(); // Al agregar un boton de direccion tenemos que desplazar los de abajo
        }   
    }
    
    private void movePhones() { // Solo se invoca si se crea un nuevo campo de direccion
        lblPhone.setBounds(10, (height + adressHeight), 150, 31);
        
        for(int i = 0; i < countPhone; i++) {          
            txtPhones[i].setBounds(310, height + adressHeight + 35 * i , 150, 31);
            boxPhones[i].setBounds(245, height + adressHeight + 35 * i, 65, 31);         
        }           
        phoneHeight = adressHeight + 35 * (countPhone - 1); // Corresponde a donde va el siguiente boton       
        btnNewPhones.setBounds(460, (height + phoneHeight), 30, 30);
    }
    
    private void createPhoneField() {        
        if (countPhone <= 4) { // Maximo van a ser 5 telefonos por contacto        
            phoneHeight += 35;
            // Usamos el propio contador como posicion a agregar
            txtPhones[countPhone] = new JTextField(" ");
            txtPhones[countPhone].setBounds(310, (height + phoneHeight), 150, 31);
            boxPhones[countPhone] = new JComboBox();
            boxPhones[countPhone].setBounds(245, (height + phoneHeight), 65, 31);
            boxPhones[countPhone].setBackground(new Color(254, 177, 57));
            boxPhones[countPhone].addItem("Movil");
            boxPhones[countPhone].addItem("Casa");
            boxPhones[countPhone].addItem("Trabajo");
            boxPhones[countPhone].addItem("Oficina");
            btnNewPhones.setBounds(460, (height + phoneHeight), 30, 30);
            
            ContenedorInfo.add(txtPhones[countPhone]); // Campos de texto
            ContenedorInfo.add(boxPhones[countPhone]); // Campos de seleccion
            countPhone += 1;
        }   
    }
    
    private void setInformation() {
        ArrayList<Contacto> contacts = utilities.getContactos();
        Contacto contact = contacts.get(position - 1);
        ArrayList<String> addresses = contact.getAddresses();
        countAdress = addresses.size();
        ArrayList<Telefono> phones = contact.getTelephones();
        countPhone = phones.size();
        createPhoneField();
        
        String IDType = contact.getID()[1];
        String role = contact.getRole();
        
        if(IDType.equals("T.I")) {
            boxID.setSelectedIndex(0);
        } else {
            boxID.setSelectedIndex(1);
        }             
        txtID.setText(contact.getID()[1]);
        txtName.setText(contact.getName());
        txtLastName.setText(contact.getLastName());
        
        switch(role) {
            case "Estudiante" -> boxRole.setSelectedIndex(0);
            case "Profesor" -> boxRole.setSelectedIndex(1);
            default -> boxRole.setSelectedIndex(2);
        }
        
        for(int i = 0; i < countPhone; i++) {
            Telefono phone = phones.get(i);
            String phonePlace = phone.getTelefono()[0];
            String phoneNumber = phone.getTelefono()[1];
            
            switch (phonePlace) {
                case "Movil" -> boxPhones[i].setSelectedIndex(0);
                case "Casa" -> boxPhones[i].setSelectedIndex(1);
                case "Trabajo" -> boxPhones[i].setSelectedIndex(2);
                default -> boxPhones[i].setSelectedIndex(3);
            }           
            txtPhones[i].setText(phoneNumber);
        }
        
        //for(int i = 0; i <)
    }
    
    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressedButton = (JButton) e.getSource();

            if (pressedButton == btnNewAddress) {
                createAddressField();           
            } else if (pressedButton == btnNewPhones) {
                createPhoneField();
            } else if(pressedButton == btnButton) { // Hacemos todas las validaciones
                boolean correctInput = true; // a priori decimos que es correcta
                ArrayList<Telefono> telephones = new ArrayList<>();
                ArrayList<String> directions = new ArrayList<>();
                String[] userID = new String[2];
                String IDNumber = txtID.getText();
                String name = txtName.getText();
                String lastName = txtLastName.getText();               
                String birth = txtBirth.getText(); // De la forma DD/MM/YYYY
                
                if(name.equals("")) {
                    correctInput = false;
                    JOptionPane.showMessageDialog(null, "Campo nombre vacio");
                } else if(lastName.equals("")) {
                    correctInput = false;
                    JOptionPane.showMessageDialog(null, "Campo apellido vacio");
                } else if(birth.equals("")) {
                    correctInput = false;
                    JOptionPane.showMessageDialog(null, "Campo nacimiento vacio");                                        
                } else if(IDNumber.equals("")) {
                    correctInput = false;
                    JOptionPane.showMessageDialog(null, "Campo identificacion vacio");                     
                }
                
                String regex = "^\\d+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(IDNumber);
                
                if(!matcher.matches()) { // Si no pasa la validacion
                    correctInput = false;
                    JOptionPane.showMessageDialog(null, "Fecha de nacimiento invalida");                    
                }
                
                regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
                pattern = Pattern.compile(regex);               
                matcher = pattern.matcher(birth);
                
                if(!matcher.matches()) {
                    correctInput = false;
                    JOptionPane.showMessageDialog(null, "Fecha de nacimiento invalida");                    
                } else {
                    String typeID = boxID.getSelectedItem().toString();
                    userID[0] = typeID;
                    userID[1] = IDNumber;                 
                }
                
                for(int i = 0; i < countPhone; i++) {
                    String stringNumber = txtPhones[i].getText();
                    System.out.println(stringNumber);
                    
                    if(stringNumber.length() == 7 || stringNumber.length() <= 10) { // Si no esta vacio, lo validamos
                        try { // Vamos a comprobar que solo sean numeros convirtiendolo en "int"
                            long number = Long.parseLong(stringNumber);
                            // Si no lo capturo el catch, lo agregamos
                            String place = boxPhones[i].getSelectedItem().toString();
                            telephones.add(new Telefono(number, place));
                            
                        } catch(NumberFormatException exception) {
                            correctInput = false;
                            JOptionPane.showMessageDialog(null, "No ha ingresado un numero o ha dejado"
                                    + " espacios en blanco");
                            break; // Si algun txtPhone esta mal escrito terminamos el for con el boolean en falso
                        }
                                               
                    } else {
                        correctInput = false;
                        JOptionPane.showMessageDialog(null, "Numero de telefono invalido");
                        break;
                    }
                }
                
                for(int i = 0; i < countAdress; i++) {
                    String direction = txtAddresses[i].getText();
                    if(direction.length() > 0) { // Si no esta vacio                      
                        directions.add(direction);
                    } else {
                        correctInput = false;
                        JOptionPane.showMessageDialog(null, "Direccion invalida");
                        break;                        
                    }
                }
                // Si cumplio con todas las verificaciones se agrega a los contactos
                if(correctInput) {
                    String role = boxRole.getSelectedItem().toString();
                    Contacto contacto = new Contacto(userID, role, name, lastName, birth, directions, telephones);
                    if(mode == 0) { // Modo de editar
                        utilities.editContacto(position, contacto);
                        JOptionPane.showMessageDialog(null, "Contacto editado con exito");
                        dispose();
                        VentanaInicio ventanaInicio = new VentanaInicio();
                    } else { // Modo agregar
                        utilities.addContacto(contacto);
                        utilities.writeContactos();
                        clearAllFields();
                        JOptionPane.showMessageDialog(null, "Contacto agregado con exito");
                    }
                }              
            } else { // Caso btnBack
                dispose();
                VentanaInicio ventanaInicio = new VentanaInicio();                   
            }
            SwingUtilities.updateComponentTreeUI(ContenedorInfo);
        }
        
    }

}


    

