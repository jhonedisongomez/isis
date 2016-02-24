package pais;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import servicios.Consultas;
import servicios.Retorno;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PaisList extends JInternalFrame {
	private JTable tablePaisList;

	/**
	 * Create the frame.
	 */
	public PaisList() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setClosable(true);
		setTitle("LISTA DE PAISES");
		setBounds(100, 100, 594, 372);
		
		JButton btnNewButton = new JButton("LISTAR PAISES");
		btnNewButton.setBounds(191, 41, 176, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel tableModelPais = new DefaultTableModel();
				tableModelPais.addColumn("NOMBRE DEL PAIS");
				tableModelPais.addColumn("CODIGO DEL PAIS");
				
				
				String query = "select  paisNom,paisCod from pais where active = true order by paisNom";
				Retorno objRetorno = Consultas.listar(query);
				if(!objRetorno.isError()){
					
					ResultSet response = objRetorno.getResponse();
					try {
						ResultSetMetaData resMetaData = response.getMetaData();
						int cantidadColumnas = resMetaData.getColumnCount();
						
						while(response.next()){
							
							Object[] filas = new Object[cantidadColumnas];
							for(int index = 0; index< cantidadColumnas; index++){
								
								filas[index] = response.getObject(index+1);
								
							}
							tableModelPais.addRow(filas);
							
						}
						
						tablePaisList.setModel(tableModelPais);
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
				}else{
					JOptionPane.showMessageDialog(null, objRetorno.getErrorMsg());
				}
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 114, 560, 214);
		getContentPane().add(scrollPane);
		
		tablePaisList = new JTable();
		scrollPane.setViewportView(tablePaisList);
		
		

	}
}
