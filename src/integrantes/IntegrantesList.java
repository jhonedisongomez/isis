package integrantes;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import diocesis.DiocesisController;
import diocesis.DiocesisModel;
import lumisial.LumisialController;
import lumisial.LumisialModel;
import pais.PaisModel;
import servicios.Consultas;
import servicios.InterfazGrafica;
import servicios.Retorno;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class IntegrantesList extends JInternalFrame {
	private JTable tableIntegrantesList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntegrantesList frame = new IntegrantesList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntegrantesList() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setClosable(true);
		setTitle("LISTAR INTEGRANTES");
		setBounds(100, 100, 832, 637);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 304, 798, 240);
		getContentPane().add(scrollPane);
		
		tableIntegrantesList = new JTable();
		scrollPane.setViewportView(tableIntegrantesList);
		
		DiocesisController objDiocesisController = new DiocesisController(); 
		DefaultComboBoxModel comboPaisModel = new DefaultComboBoxModel(objDiocesisController.loadDataCombo());
		
		final JPanel panelSelecLumisial = new JPanel();
		panelSelecLumisial.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "SELECCIONE EL LUMISIAL", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panelSelecLumisial.setBackground(Color.LIGHT_GRAY);
		panelSelecLumisial.setBounds(58, 108, 385, 158);
		getContentPane().add(panelSelecLumisial);
		panelSelecLumisial.setLayout(null);
		
		final JComboBox comboLumisial = new JComboBox();
		comboLumisial.setBounds(161, 116, 203, 30);
		panelSelecLumisial.add(comboLumisial);
		
		final JComboBox comboDiocesis = new JComboBox();
		comboDiocesis.setBounds(161, 74, 203, 30);
		panelSelecLumisial.add(comboDiocesis);
		
		final JComboBox comboPais = new JComboBox();
		comboPais.setBounds(161, 32, 203, 30);
		panelSelecLumisial.add(comboPais);
		comboPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboDiocesis.removeAllItems();
				comboLumisial.removeAllItems();
				
				PaisModel objPaisModel = (PaisModel)comboPais.getSelectedItem();
				int paisCod = objPaisModel.getPaisCod();
				
				
				LumisialController objLumisialController = new LumisialController();
				DefaultComboBoxModel comboDiocesisModel = new DefaultComboBoxModel(objLumisialController.loadDataDiocesisCombo(paisCod));
				comboDiocesis.setModel(comboDiocesisModel);
			
				
				
			}
		});
		comboPais.setModel(comboPaisModel);
				
		
		
		final JComboBox comboOpcion = new JComboBox();
		comboOpcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int seleccionado = comboOpcion.getSelectedIndex();
				switch(seleccionado){
					case 0:
					JOptionPane.showMessageDialog(null, "POR FAVOR SELECCIONE UNA OPCION");
					break;
				
					case 1:
						InterfazGrafica.CambiarEstadoElem(panelSelecLumisial, true);
					break;

					case 2:
						InterfazGrafica.CambiarEstadoElem(panelSelecLumisial, false);
						
						panelSelecLumisial.setEnabled(true);
						comboPais.setEnabled(true);
						comboDiocesis.setEnabled(true);
					break;

				}
				
			}
		});
		comboOpcion.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONE UNA OPCION", "POR LUMISIAL", "TODA LA DIOCESIS"}));
		comboOpcion.setBounds(207, 54, 203, 24);
		getContentPane().add(comboOpcion);

		
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tableModelIntegrantes = new DefaultTableModel();
				tableModelIntegrantes.addColumn("NOMBRE");
				tableModelIntegrantes.addColumn("CARGOS");
				tableModelIntegrantes.addColumn("LUMISIAL");
				tableModelIntegrantes.addColumn("ESTADO CIVIL");
				
				int seleccionado = comboOpcion.getSelectedIndex();
				String query = "";
					
					if(seleccionado ==1){
						
						LumisialModel objLumisialModel = (LumisialModel) comboLumisial.getSelectedItem();
						int lumisialCod = objLumisialModel.getLumisialCode();
						query = "SELECT concat_ws(' ',primerNom,segundoNom,primerApe,segundoApe) as nombre,cargos,fk_lumisialCod,"
								+"fk_estadoCivilCod FROM asistente WHERE active = true and fk_lumisialCod =" + lumisialCod;
						
					}else{
						
						//capturar la diocesis
						DiocesisModel objDiocesisModel = (DiocesisModel) comboDiocesis.getSelectedItem();
						int diocesisCod = objDiocesisModel.getDiocesisCod();
						query = "SELECT concat_ws(' ',primerNom,segundoNom,primerApe,segundoApe) as nombre,cargos,fk_lumisialCod,fk_estadoCivilCod FROM asistente inte INNER JOIN lumisial lumi "
								+ "ON inte.fk_lumisialCod = lumi.lumisialCod INNER JOIN ciudad ciu "
								+ "ON lumi.fk_ciudadCod = ciu.ciudadCod  INNER JOIN diosesis dio "
								+ "ON ciu.fk_diocesisCod = dio.diosesisCod "
								+ "WHERE "
								+ "inte.active = true AND "
								+ "lumi.active = true AND "
								+ "dio.active = true AND "
								+ "dio.diosesisCod =" + diocesisCod
								+ " order by primerNom";
						
				}
				
				
				Retorno objRetorno = Consultas.listar(query);
				if(!objRetorno.isError()){
					
					ResultSet response = objRetorno.getResponse();
					try {
						ResultSetMetaData resMetaData = response.getMetaData();
						int cantidadColumnas = resMetaData.getColumnCount();
						
						while(response.next()){
							Object[] filas = new Object[cantidadColumnas];
							
							for(int index = 0;index < cantidadColumnas; index++){
								
								switch(index){
									
									//case para el nombre del lumisial
									case 2:
									
										String getLumisialCod = response.getObject(index+1).toString();
										String lumisialNom = Consultas.lumisialNom(getLumisialCod);
										filas[index] = lumisialNom;
									
									break;
									
									//case para el nombre del estado civil
									case 3:
										
										String getestadoCivilCod = response.getObject(index+1).toString();
										String estadoCivilDesc = Consultas.EstadiCivilDesc(getestadoCivilCod);
										filas[index] = estadoCivilDesc;
										
									break;
									
									default:
										filas[index] = response.getObject(index+1);
									break;	
								
								}
								
							}
							tableModelIntegrantes.addRow(filas);
						}
						tableIntegrantesList.setModel(tableModelIntegrantes);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else{
					
					JOptionPane.showMessageDialog(null, objRetorno.getErrorMsg());
				}
			}
		});
		btnListar.setBounds(485, 50, 117, 33);
		getContentPane().add(btnListar);
		
		JLabel lblListarPor = new JLabel("LISTAR POR");
		lblListarPor.setBounds(58, 63, 80, 15);
		getContentPane().add(lblListarPor);
		
		JButton btnExportar = new JButton("EXPORTAR EXCEL");
		btnExportar.setBounds(160, 556, 152, 25);
		getContentPane().add(btnExportar);
		
		JLabel lblPais = new JLabel("PAIS");
		lblPais.setBounds(12, 41, 70, 15);
		panelSelecLumisial.add(lblPais);
		
		JLabel lblDiocesis = new JLabel("DIOCESIS");
		lblDiocesis.setBounds(12, 83, 70, 15);
		panelSelecLumisial.add(lblDiocesis);
		
		JLabel lblLumisial = new JLabel("LUMISIAL");
		lblLumisial.setBounds(12, 124, 70, 15);
		panelSelecLumisial.add(lblLumisial);
		
		comboDiocesis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboOpcion.getSelectedIndex() != 2){
				
					DiocesisModel objDiocesisModel = (DiocesisModel)comboDiocesis.getSelectedItem();
					
					if(objDiocesisModel != null){
						
						int diocesisCod = objDiocesisModel.getDiocesisCod();
						IntegrantesController objIntegrantesController = new IntegrantesController();
						DefaultComboBoxModel comboLumisialModel = new DefaultComboBoxModel(objIntegrantesController.loadDataLumisialCombo(diocesisCod));
						comboLumisial.setModel(comboLumisialModel);	
					}
				}
				
					
				
			}
		});
		
		
		InterfazGrafica.CambiarEstadoElem(panelSelecLumisial, false);
				

	}
}
