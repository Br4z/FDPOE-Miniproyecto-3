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
import javax.swing.*;

/**
 *  CLASE:     VentanaAgregar
 *  INTENCION: Ser la ventana donde se presentan las opciones del directiorio telefonico.
 *  RELACION:  NINGUNA 
 */

public class VentanaAgregar extends JFrame {
    private Color orange = new Color(254, 177, 57);
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
    private JTextField txtAddress   = new JTextField();
    private JComboBox boxID         = new JComboBox();
    private JComboBox boxRole       = new JComboBox();
    private JTextField txtBirth     = new JTextField();
    
    private JTextField[] txtAddressFields = new JTextField[10];
    private int CountAdress = 1; // Empezamos con una direccion y minimamente debe tener uno
    private int height = 210; // Para llevar control de la creacion de los recuadros
    
    private JTextField[] txtPhones = new JTextField[5];
    private JComboBox[] boxPhones  = new JComboBox[5];
    private int countPhone = 1; // Empezamos con un telefono y minimamente debe tener uno
       
    private JButton btnNewAddress = new JButton("+");
    private JButton btnNewPhones  = new JButton("+");
    private JButton btnAdd        = new JButton("Agregar");;
    private JButton btnBack       = new JButton("Volver");;
       
    private Container ContenedorInfo;
    
    public VentanaAgregar() {
    initializeComponents();        
        setSize(510, 500);
        setTitle("Directorio telefonico - Añadir Contacto");
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
           
        btnNewAddress.setBackground(orange);
        btnNewAddress.setBounds(530, 220, 30, 30);
             
        btnNewPhones.setBackground(orange);
        btnNewPhones.setBounds(460, height, 30, 30);
        
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
        pnl1.add(txtAddress);
        
        lblPhone.setBounds(10, height, 150, 31);
        txtPhones[countPhone] = new JTextField(" ");
        txtPhones[countPhone].setBounds(310, height, 150, 31);
        boxPhones[countPhone] = new JComboBox();
        boxPhones[countPhone].setBounds(245, height, 65, 31);
        boxPhones[countPhone].setBackground(orange);
        boxPhones[countPhone].addItem("Movil");
        boxPhones[countPhone].addItem("Casa");
        boxPhones[countPhone].addItem("Trabajo");
        boxPhones[countPhone].addItem("Oficina");
                       
        ContenedorInfo = getContentPane();
        ContenedorInfo.setLayout(null);
        ContenedorInfo.setBackground(new Color(214, 239, 237));
        ContenedorInfo.add(pnl1);
        ContenedorInfo.add(btnAdd);
        ContenedorInfo.add(btnBack);
        ContenedorInfo.add(btnNewAddress);
        ContenedorInfo.add(btnNewPhones);
        ContenedorInfo.add(lblPhone);
        ContenedorInfo.add(txtPhones[countPhone]);
        ContenedorInfo.add(boxPhones[countPhone]);
       
        SwingUtilities.updateComponentTreeUI(ContenedorInfo);
    }
    
    private void createAddressField() {
        if (CountAdress<=3) { 
            System.out.println("" + CountAdress);
            txtAddressFields[CountAdress] = new JTextField(" ");
            txtAddressFields[CountAdress].setBounds(300, height, 215, 31);
            height += 35;
            ContenedorInfo.add(txtAddressFields[CountAdress]);
            CountAdress += 1;          
        }   
    }
    
    private void movePhones() {
        lblPhone.setBounds(10, (height + 37), 150, 31);
        btnNewPhones.setBounds(460, (37 + height), 30, 30);
        
        for(int i = 0; i < countPhone; i++) {
            System.out.println("" + countPhone);
            System.out.println("" + i);
            boxPhones[countPhone].setBounds(300, (height + (37 * (i + 1))), 65, 31);
            txtPhones[countPhone].setBounds(365, (height+(37 * (i + 1))), 150, 31);
        }       
    }
    
    private void createPhoneField() {        
        if (countPhone <= 4) { // Maximo van a ser 5 telefonos por contacto
            System.out.println(countPhone);
            // Usamos el propio contador como posicion a agregar
            txtPhones[countPhone] = new JTextField(" ");
            txtPhones[countPhone].setBounds(310, (height + 37), 150, 31);
            boxPhones[countPhone] = new JComboBox();
            boxPhones[countPhone].setBounds(245, (height + 37), 65, 31);
            boxPhones[countPhone].setBackground(new Color(254, 177, 57));
            boxPhones[countPhone].addItem("Movil");
            boxPhones[countPhone].addItem("Casa");
            boxPhones[countPhone].addItem("Trabajo");
            boxPhones[countPhone].addItem("Oficina");
            btnNewPhones.setBounds(460, (37 + height), 30, 30);
            
            height += 35;
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
                movePhones(); // Al agregar un boton de direccion tenemos que desplazar los de abajo
                createAddressField();
            } else if (pressedButton == btnNewPhones) {
                createPhoneField();
            } else if(pressedButton == btnAdd) { // Hacemos todas las validaciones
                boolean correctInput = true; // a priori decimos que es correcta
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


    

