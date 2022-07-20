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
 *  CLASE:     VentanaInicio
 *  INTENCION: Ser la ventana donde se presentan las opciones del directiorio telefonico.
 *  RELACION:  NINGUNA 
 */

public class VentanaEleccion extends JFrame {        
    private JLabel lblTitulo;   
    private JPanel pnlBotones;
    private JPanel pnlBotones2;    
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnAppend;
    private JButton btnList;    
    private Container ContenedorInfo;
    
    public VentanaEleccion() {
        initializeComponents();        
        setSize(400, 400);
        setTitle("Directorio telefonico - Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);        
    }

    private void initializeComponents() {        
        lblTitulo = new JLabel("Miembros Univalle");
        lblTitulo.setBounds(100, 50, 200, 80);
        lblTitulo.setFont(new Font("Serif", Font.ROMAN_BASELINE, 25));
        
        pnlBotones = new JPanel(new GridLayout(1, 2, 20, 20));
        pnlBotones.setBounds(70, 150, 250, 50);
        pnlBotones.setBackground(Color.white);
        
        pnlBotones2 = new JPanel(new GridLayout(1, 2, 20, 20));
        pnlBotones2.setBounds(70, 220, 250, 50);
        pnlBotones2.setBackground(Color.white);
        
        btnAppend = new JButton("Añadir");
        btnAppend.setBackground(Color.LIGHT_GRAY);
                
        btnUpdate = new JButton("Actualizar");
        btnUpdate.setBackground(Color.LIGHT_GRAY);
                      
        btnDelete = new JButton("Elminar");
        btnDelete.setBackground(Color.LIGHT_GRAY);

        btnList = new JButton("Listar");
        btnList.setBackground(Color.LIGHT_GRAY);
        
        btnAppend.addActionListener(new actionListener());
        btnUpdate.addActionListener(new actionListener());
        btnDelete.addActionListener(new actionListener());
        btnList.addActionListener(new actionListener());
        
        pnlBotones.add(btnAppend);
        pnlBotones.add(btnUpdate);
        pnlBotones2.add(btnDelete);
        pnlBotones2.add(btnList);
        
        ContenedorInfo = getContentPane();
        ContenedorInfo.setLayout(null);
        
        ContenedorInfo.add(pnlBotones);
        ContenedorInfo.add(pnlBotones2);
        ContenedorInfo.add(lblTitulo);
        ContenedorInfo.setBackground(Color.white);                      
    }
   
    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressedButton = (JButton) e.getSource();
            
            if(pressedButton == btnAppend) {
                dispose();
                VentanaAgregar ventanaAgregar = new VentanaAgregar();               
            } else if(pressedButton == btnUpdate) {
                dispose();
            } else if(pressedButton == btnList) {
                dispose();
            } else { // Caso del btnDelete
                dispose();
            }           
        }       
    }
}
