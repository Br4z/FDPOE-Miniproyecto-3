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
    private JPanel pnl1;   
    private JLabel lblId;
    private JLabel lblBirth;
    private JLabel lblName;
    private JLabel lblLastName;
    private JLabel lblAddress;
    private JLabel lblPhone;
    private JLabel lblContacto;
    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtLastName;
    private JTextField txtAddress;
    private JTextField txtPhone;
    private JComboBox boxContacto;
    private JTextField txtDateBirth;
    private JComboBox boxPhone;
    
    private JTextField[] txtAddressFields = new JTextField[10];
    private int CountAdress;
    private int height = 254; // Para llevar control de la creacion de los recuadros
    
    private JTextField[] txtPhones = new JTextField[10];
    private JComboBox[] boxPhones = new JComboBox[10];
    private int countPhone = 0;
       
    private JButton btnNewAddress;
    private JButton btnNewPhones;
       
    private Container ContenedorInfo;
    
    public VentanaAgregar() {
    initializeComponents();        
        setSize(510, 600);
        setTitle("Directorio telefonico - Añadir Contacto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);        
    }

    private void initializeComponents() {
        pnl1 = new JPanel(new GridLayout(6, 2, 20, 5));
        pnl1.setBounds(10, 50, 450, 200);
        pnl1.setBackground(null);
                
        lblId = new JLabel("Identificacion:");
        txtID = new JTextField();
        lblName = new JLabel("Nombres:");
        txtName = new JTextField();
        lblLastName = new JLabel("Apellidos:");
        txtLastName = new JTextField();
        lblAddress = new JLabel("Direccion:");
        txtAddress = new JTextField();
        
        lblContacto = new JLabel("Rol:");
        boxContacto = new JComboBox();
        boxContacto.addItem("Estudiante");
        boxContacto.addItem("Profesor");
        boxContacto.addItem("Empleado");
        boxContacto.setBackground(new Color(254, 177, 57));
        
        lblBirth = new JLabel("Fecha de Nacimiento:");
        txtDateBirth = new JTextField();
        
        btnNewAddress = new JButton("+");
        btnNewAddress.setBackground(new Color(254, 177, 57));
        btnNewAddress.setBounds(530, 220, 30, 30);
             
        btnNewPhones = new JButton("+");
        btnNewPhones.setBackground(new Color(254, 177, 57));
        btnNewPhones.setBounds(465, height, 30, 30);
        
        btnNewAddress.addActionListener(new actionListener());
        btnNewPhones.addActionListener(new actionListener());             
        
        pnl1.add(lblId);
        pnl1.add(txtID);
        pnl1.add(lblName);
        pnl1.add(txtName);
        pnl1.add(lblLastName);
        pnl1.add(txtLastName);
        pnl1.add(lblBirth);
        pnl1.add(txtDateBirth);        
        pnl1.add(lblContacto);
        pnl1.add(boxContacto);      
        pnl1.add(lblAddress);
        pnl1.add(txtAddress);
        
        lblPhone = new JLabel("Telefono:");
        lblPhone.setBounds(10, height, 150, 31);
        txtPhone = new JTextField();
        txtPhone.setBounds(315, height, 150, 31);
        boxPhone= new JComboBox();
        boxPhone.setBounds(245, height, 65, 31);
        boxPhone.setBackground(new Color(254, 177, 57));
        boxPhone.addItem("Movil");
        boxPhone.addItem("Casa");
        boxPhone.addItem("Trabajo");
        boxPhone.addItem("Oficina");
                       
        ContenedorInfo = getContentPane();
        ContenedorInfo.setLayout(null);
        ContenedorInfo.setBackground(new Color(214, 239, 237));
        ContenedorInfo.add(pnl1);
        ContenedorInfo.add(btnNewAddress);
        ContenedorInfo.add(btnNewPhones);
        ContenedorInfo.add(lblPhone);
        ContenedorInfo.add(boxPhone);
        ContenedorInfo.add(txtPhone);
        
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
        lblPhone.setBounds(65,(height + 37), 150, 31);
        txtPhone.setBounds(365, (height + 37), 150, 31);
        boxPhone.setBounds(300, (37 + height), 65, 31);
        btnNewPhones.setBounds(530, (37 + height), 30, 30);
        
        for (int i = 0; i < countPhone; i++) {
            System.out.println(""+ countPhone);
            System.out.println(""+ i);
            boxPhones[countPhone].setBounds(300, (height+(37*(i+1))), 65, 31);
            txtPhones[countPhone].setBounds(365, (height+(37*(i+1))), 150, 31);
        }
        
    }
    
    private void createPhoneField() {        
        if (countPhone<=3) { 
            // Usamos el propio contador como posicion a agregar
            txtPhones[countPhone]= new JTextField(" ");
            txtPhones[countPhone].setBounds(365, (height + 37), 150, 31);
            boxPhones[countPhone] = new JComboBox();
            boxPhones[countPhone].setBounds(300, (height + 37), 65, 31);
            boxPhones[countPhone].setBackground(new Color(254, 177, 57));
            boxPhones[countPhone].addItem("Movil");
            boxPhones[countPhone].addItem("Casa");
            boxPhones[countPhone].addItem("Trabajo");
            boxPhones[countPhone].addItem("Oficina");
            
            height += 35;
            ContenedorInfo.add(txtPhones[countPhone]);
            ContenedorInfo.add(boxPhones[countPhone]);
            countPhone += 1;                       
        }   
    }

    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressedButton = (JButton) e.getSource();
            
            if (pressedButton == btnNewAddress) {
                movePhones();
                createAddressField();
            } else if (e.getSource()==btnNewPhones) {
                createPhoneField();
            }
            SwingUtilities.updateComponentTreeUI(ContenedorInfo);
        }
        
    }

}


    

