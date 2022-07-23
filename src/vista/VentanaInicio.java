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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import logica.*;

/**
 *  CLASE:     VentanaInicio
 *  INTENCION: Ser la ventana donde se presentan las opciones del directiorio telefonico.
 *  RELACION:  NINGUNA 
 */

public class VentanaInicio extends JFrame {
    private Utilities utilities          = new Utilities();
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JScrollPane jScrollPane;
    private JTable dataTable             = new JTable();
    private JButton btnLoad              = new JButton("Cargar");
    private JButton btnExport            = new JButton("Exportar");;
    private JButton btnSearch            = new JButton("Buscar");;
    private JButton btnAdd               = new JButton("Agregar");;    
    private JButton btnUpdate            = new JButton("Actualizar");;
    private JButton btnDelete            = new JButton("Eliminar");;
            
    public VentanaInicio() {
        initializeComponents();
        listContactos();
        setSize(600, 550);
        setTitle("Directorio telefonico - Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);        
    }

    private void initializeComponents() {
        
        setLayout(null); // Desactivamos la distribución por defecto             
        String[] titles = {"Posicion", "ID", "Nombre", "Apellido", "Rol", "Telefono", "Nacimiento"};
        tableModel.setColumnIdentifiers(titles);
        dataTable.setModel(tableModel);
        
        jScrollPane = new JScrollPane(dataTable);
        jScrollPane.setBounds(10, 50, 560, 300);
        
        btnAdd.setBounds(100, 300, 300, 300);
        add(jScrollPane);
        add(btnAdd);
        
        btnAdd.addActionListener(new actionListener());
    }
    
    private void listContactos() {
        ArrayList<Contacto> contactos = utilities.getContactos();
        
        for(Contacto contacto:contactos) {
            int position = contacto.getPosition();
            String ID = contacto.getID()[0] + " " + contacto.getID()[1];
            String name = contacto.getName();
            String lastName = contacto.getLastName();
            String role = contacto.getRole();
            String telephone = contacto.getTelephones().get(0).getTelefono()[0] + " " + contacto.getTelephones().get(0).getTelefono()[1];
            // Mostramos el primer telefono agregado
            String birth = contacto.getBirth();
            
            tableModel.addRow(new Object[] {
            position, ID, name, lastName, role, telephone, birth 
            });
        }
        

    }
    
    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressButton = (JButton) e.getSource();
            
            if(pressButton == btnAdd) {
                dispose();
                VentanaManipularContactos ventanaAgregar = new VentanaManipularContactos();
            }
        }
        
    }
}
