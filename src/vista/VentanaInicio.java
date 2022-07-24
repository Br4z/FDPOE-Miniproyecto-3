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

package vista;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    private JTable dataTable             = new JTable();
    private JScrollPane jScrollPane;
    private JButton btnImport            = new JButton("Importar");
    private JButton btnExport            = new JButton("Exportar");;
    //private JButton btnSearch            = new JButton("Buscar");;
    private JButton btnAdd               = new JButton("Agregar");;    
    private JButton btnEdit              = new JButton("Editar");;
    private JButton btnDelete            = new JButton("Eliminar");;

    //private JTextField txtSearch         = new JTextField();
    private JLabel lblContacts           = new JLabel("Contactos");
            
    public VentanaInicio() {
        initializeComponents();
        listContactos();
        setSize(600, 480);
        setTitle("Directorio telefonico - Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);        
    }

    private void initializeComponents() {
        Toolkit myScreen = Toolkit.getDefaultToolkit(); 
        // Para establecer el icono en la aplicación
        Image icon = myScreen.getImage("src/imagenes/icon.png");        
	setIconImage(icon);
        
        setLayout(null); // Desactivamos la distribución por defecto             
        String[] titles = {"Posicion", "ID", "Nombre", "Apellido", "Rol", "Telefono", "Nacimiento"};
        tableModel.setColumnIdentifiers(titles);
        dataTable.setModel(tableModel);
        
        jScrollPane = new JScrollPane(dataTable);
        jScrollPane.setBounds(10, 50, 560, 330);
        add(jScrollPane);
        
        btnAdd.setBounds(410, 400, 80, 30);   
        add(btnAdd);
        
        btnDelete.setBounds(491, 400, 80, 30);
        add(btnDelete);
        
        btnEdit.setBounds(329, 400, 80, 30);
        add(btnEdit);
        
        //btnSearch.setBounds(30, 400, 80, 30);
        //add(btnSearch);
        //txtSearch.setBounds(111, 400, 149, 32);
        //add(txtSearch);
        
        lblContacts.setBounds(10, 0, 200, 60);
        lblContacts.setFont(new Font("Helvetica", Font.ITALIC,20 ));
        add(lblContacts);
        
        btnImport.setBounds(390, 10, 90, 30);
        add(btnExport);
        
        btnExport.setBounds(481, 10, 90, 30);
        add(btnImport);
        
        btnAdd.addActionListener(new actionListener());
        btnDelete.addActionListener(new actionListener());
        btnEdit.addActionListener(new actionListener());
        btnExport.addActionListener(new actionListener());
        btnImport.addActionListener(new actionListener());
    }
    
    private void updateTable() {
        ((DefaultTableModel) dataTable.getModel()).setNumRows(0); // Limpiamos la tabla
        listContactos();
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
    
    private File getFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt"); // Alias, extension
        fileChooser.setFileFilter(filter);
                
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.CANCEL_OPTION) return null;
        
        File file = fileChooser.getSelectedFile();
                
        if((file == null) || (file.getName().equals(""))) {
            JOptionPane.showMessageDialog(null, "Invalid Name", "Invalid Name", JOptionPane.ERROR_MESSAGE);          
            System.exit(1);
        }
        return file;
    }    
    
    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressButton = (JButton) e.getSource();
            int contactPosition = dataTable.getSelectedRow();
            
            if(pressButton == btnAdd) {
                dispose();
                VentanaGestionarContactos ventanaAgregar = new VentanaGestionarContactos();
            } else if (pressButton == btnDelete) {               
                utilities.deleteContacto(contactPosition);
                utilities.writeContactos(); 
                updateTable();
            } else if (pressButton == btnEdit) {                
                dispose();
                VentanaGestionarContactos ventanaEditar = new VentanaGestionarContactos(contactPosition);
                utilities.writeContactos();   
            } //else if (pressButton== btnSearch) {
                //String matches = "";
                //String property = txtSearch.getText();
               // ArrayList<Contacto> contacts = utilities.getContactos();
                
                //for(Contacto contac:contacts) {
                   // //String name
                //}
            else if (pressButton == btnImport || pressButton== btnExport) {
                File file = getFile();
                
                if(pressButton== btnImport) {
                    utilities.importOrExportFile(file, "Import");
                    updateTable();
                } else {
                    utilities.importOrExportFile(file, "Export");
                }                    
            }           
        }     
    }
}