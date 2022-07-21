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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *  CLASE:     VentanaInicio
 *  INTENCION: Ser la ventana donde se presentan las opciones del directiorio telefonico.
 *  RELACION:  NINGUNA 
 */

public class VentanaListar extends JFrame {
    DefaultTableModel tableModel = new DefaultTableModel();
    private JTable dataTable  = new JTable();
    private JButton btnLoad   = new JButton("Cargar");
    private JButton btnExport = new JButton("Exportar");;
    private JButton btnSearch = new JButton("Buscar");;
    private JButton btnAdd    = new JButton("Agregar");;    
    private JButton btnUpdate = new JButton("Actualizar");;
    private JButton btnDelete = new JButton("Eliminar");;
            
    public VentanaListar() {
        initializeComponents();        
        setSize(600, 800);
        setTitle("Directorio telefonico - Listado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null); // Posición de la ventana en el centro
        setResizable(false);        
    }

    private void initializeComponents() {
        
        setLayout(null); // Desactivamos la distribución por defecto
        
        
        String[] titles = {"Numbero", "Nombre", "Direccion", "Telefono", "Fecha"};
        tableModel.setColumnIdentifiers(titles);
        dataTable.setModel(tableModel);
        

        dataTable.setBounds(100, 0, 300, 300);
        btnAdd.setBounds(100, 300, 300, 300);
        add(btnAdd);
        add(dataTable);
        
        btnAdd.addActionListener(new actionListener());
    }
    
    private class actionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressButton = (JButton) e.getSource();
            
            if(pressButton == btnAdd) {
                tableModel.addRow(new Object[] {
                    "Numbero", "Nombre", "Direccion", "Telefono", "Fecha"   
                });
            }
        }
        
    }
}
