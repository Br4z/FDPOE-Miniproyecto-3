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
import javax.swing.*;

import logica.*;

/**
 *  CLASE:     VentanaAgregar
 *  INTENCION: Ser la ventana donde se presentan las opciones del directiorio telefonico.
 *  RELACION:  NINGUNA 
 */

public class VentanaAgregar extends JFrame {
    private Color orange            = new Color(254, 177, 57);
    private JPanel pnl1             = new JPanel(new GridLayout(6, 2, 20, 5));  // Va a contener 
    // todos los campos, excepto los telefonos   
    private JLabel lblID            = new JLabel("Identificacion:");
    private JLabel lblBirth         = new JLabel("Fecha de Nacimiento:");
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
    private int adressHeight = 35;
    
    private JTextField[] txtPhones = new JTextField[5];
    private JComboBox[] boxPhones  = new JComboBox[5];
    private int phoneHeight = 0; // Para llevar control de la creacion de los recuadros
    private int countPhone = 1; // Empezamos con un telefono y minimamente debe tener uno
       
    private JButton btnNewAddress = new JButton("+");
    private JButton btnNewPhones  = new JButton("+");
    private JButton btnAdd        = new JButton("Agregar");;
    private JButton btnBack       = new JButton("Volver");;
       
    private Container ContenedorInfo;
    
    public VentanaAgregar() {
    initializeComponents();        
        setSize(510, 500);
        setTitle("Directorio telefonico - Agregar Contacto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);        
    }

    private void initializeComponents() {        
        pnl1.setBounds(10, 5, 450, 200);
        pnl1.setBackground(null);
                        
        boxRole.addItem("Estudiante");
        boxRole.addItem("Profesor");
        boxRole.addItem("Empleado");
        boxRole.setBackground(orange);
        
        boxID.addItem("T.I");
        boxID.addItem("C.C");
        boxID.setBackground(orange);
        
        txtAddresses[0] = new JTextField();
        
        btnNewAddress.setBackground(orange);
        btnNewAddress.setBounds(460, 200 - 25, 30, 30); // 25 = 30 / 2 + 5
             
        btnNewPhones.setBackground(orange);
        btnNewPhones.setBounds(460, phoneHeight + height, 30, 30);
        
        btnAdd.setBounds(50, 400, 100, 50);
        btnBack.setBounds(350, 400, 100, 50);
        
        btnAdd.addActionListener(new actionListener());
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
        
        lblPhone.setBounds(10, phoneHeight + height, 150, 31);
        txtPhones[0] = new JTextField(); // - 1 para la posicion 0
        txtPhones[0].setBounds(310, phoneHeight + height, 150, 31);
        boxPhones[0] = new JComboBox();
        boxPhones[0].setBounds(245, phoneHeight + height, 65, 31);
        boxPhones[0].setBackground(orange);
        boxPhones[0].addItem("Movil");
        boxPhones[0].addItem("Casa");
        boxPhones[0].addItem("Trabajo");
        boxPhones[0].addItem("Oficina");           
                       
        ContenedorInfo = getContentPane();
        ContenedorInfo.setLayout(null);
        ContenedorInfo.setBackground(new Color(214, 239, 237));
        ContenedorInfo.add(pnl1);
        ContenedorInfo.add(btnAdd);
        ContenedorInfo.add(btnBack);
        ContenedorInfo.add(btnNewAddress);
        ContenedorInfo.add(btnNewPhones);
        ContenedorInfo.add(lblPhone);
        ContenedorInfo.add(txtPhones[0]);
        ContenedorInfo.add(boxPhones[0]);
       
        SwingUtilities.updateComponentTreeUI(ContenedorInfo);
    }
    
    private void createAddressField() {
        if (countAdress<=4) { // Maximo van a ser 5 direcciones por contacto
            System.out.println("" + countAdress);
            txtAddresses[countAdress] = new JTextField();
            txtAddresses[countAdress].setBounds(245, height + adressHeight, 180, 31);
            
            adressHeight += 35;
            ContenedorInfo.add(txtAddresses[countAdress]);
            countAdress += 1;          
        }   
    }
    
    private void movePhones() {
        lblPhone.setBounds(10, (height  + adressHeight + 35), 150, 31);
        btnNewPhones.setBounds(460, (height + adressHeight + phoneHeight + 35), 30, 30);
        
        for(int i = 0; i < countPhone; i++) {
            System.out.println("" + countPhone);
            System.out.println("" + i);
            boxPhones[countPhone].setBounds(300, (phoneHeight + (37 * (i + 1))), 65, 31);
            txtPhones[countPhone].setBounds(365, (phoneHeight + (37 * (i + 1))), 150, 31);
        }       
    }
    
    private void createPhoneField() {        
        if (countPhone <= 4) { // Maximo van a ser 5 telefonos por contacto
            System.out.println(countPhone);
            phoneHeight += 35;
            // Usamos el propio contador como posicion a agregar
            txtPhones[countPhone] = new JTextField(" ");
            txtPhones[countPhone].setBounds(310, (phoneHeight + height), 150, 31);
            boxPhones[countPhone] = new JComboBox();
            boxPhones[countPhone].setBounds(245, (phoneHeight + height), 65, 31);
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

    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressedButton = (JButton) e.getSource();
            
            if (pressedButton == btnNewAddress) {
                createAddressField();
                movePhones(); // Al agregar un boton de direccion tenemos que desplazar los de abajo              
            } else if (pressedButton == btnNewPhones) {
                createPhoneField();
            } else if(pressedButton == btnAdd) { // Hacemos todas las validaciones
                boolean correctInput = true; // a priori decimos que es correcta
                ArrayList<Telefono> telephones = new ArrayList<>();
                String name = txtName.getText();
                String lastName = txtLastName.getText();
                String ID = txtID.getText();
                String birth = txtBirth.getText(); // De la forma DD/MM/YYYY
                
                if(name.equals("")) {
                    correctInput = false;
                    JOptionPane.showMessageDialog(null, "Nombre invalido");
                } else if(lastName.equals("")) {
                    correctInput = false;
                    JOptionPane.showMessageDialog(null, "Apellido invalido");
                } else if(birth.equals("")) {
                    correctInput = false;
                    JOptionPane.showMessageDialog(null, "Nacimiento invalido");                                        
                } else if(ID.equals("")) {
                    correctInput = false;
                    JOptionPane.showMessageDialog(null, "Identificacion invalida");                     
                }
                
                for(int i = 0; i < txtPhones.length; i++) {
                    String stringNumber = txtPhones[0].getText();
                    if(stringNumber.length() == 10) { // Si no esta vacio, lo validamos
                        try { // Vamos a comprobar que solo sean numeros convirtiendolo en "int"
                            int number = Integer.parseInt(stringNumber);
                            // Si no lo capturo el catch, lo agregamos
                            String place = boxPhones[i].getSelectedItem().toString();
                            telephones.add(new Telefono(number, place));
                            
                        } catch(NumberFormatException exception) {
                            correctInput = false;
                            JOptionPane.showMessageDialog(null, "No ha ingresado un numero o ha dejado"
                                    + " espacios en blanco");
                            break; // Si algun txtPhone esta mal escrito terminamos el for con el boolean en falso
                        }
                        
                        
                    }
                }
                // Si cumplio con todas las verificaciones se agrega a los contactos
                if(correctInput) {
                    String role = boxRole.getSelectedItem().toString();
                    //Contacto contacto = new Contacto(role, name, lastName)
                }
                
            } else { // Caso btnBack
                dispose();
                VentanaInicio ventanaInicio = new VentanaInicio();
                    
            }
            SwingUtilities.updateComponentTreeUI(ContenedorInfo);
        }
        
    }

}


    

