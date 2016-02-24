package integrantes;

import javax.swing.JInternalFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.Blob;

import diocesis.DiocesisController;
import diocesis.DiocesisModel;
import estadoCivil.EstadoCivilModel;
import lumisial.LumisialController;
import lumisial.LumisialModel;
import pais.PaisModel;
import servicios.InterfazGrafica;
import servicios.Retorno;

import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

public class IntegrantesView extends JInternalFrame {
	private JTextField txtSegundoApe;
	private JTextField txtPrimerNom;
	private JTextField txtSegunNom;
	private JTextField txtPrimerApe;
	private JTextField txtOcupacion;
	private JTextField txtIdentidad;
	private JTextField txtNumCarnet;
	private JTextField txtCelular;
	
	IntegrantesController objIntegrantesController = new IntegrantesController();

	/**
	 * Create the frame.
	 */
	public IntegrantesView() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setClosable(true);
		setTitle("REGISTRO DE INTEGRANTES");
		setBounds(100, 100, 1289, 596);
		getContentPane().setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "DOCUMENTO DE IDENTIDAD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBounds(35, 12, 1232, 90);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNumeroDeDocumento = new JLabel("NUMERO DE DOCUMENTO");
		lblNumeroDeDocumento.setBounds(12, 37, 183, 17);
		panel.add(lblNumeroDeDocumento);
		lblNumeroDeDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtIdentidad = new JTextField();
		txtIdentidad.setBounds(213, 32, 197, 28);
		panel.add(txtIdentidad);
		txtIdentidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdentidad.setColumns(10);
		
		final JComboBox comboOpcionBusqueda = new JComboBox();
		comboOpcionBusqueda.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONE UNA BUSQUEDA", "CEDULA", "CARNET"}));
		comboOpcionBusqueda.setBounds(628, 30, 233, 30);
		panel.add(comboOpcionBusqueda);

		
		JLabel lblTipoDeDocumento = new JLabel("BUSQUEDA POR");
		lblTipoDeDocumento.setBounds(457, 37, 153, 17);
		panel.add(lblTipoDeDocumento);
		lblTipoDeDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(null, "DATOS PERSONALES", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(35, 114, 1232, 155);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_7 = new JLabel("PRIMER NOMBRE");
		label_7.setBounds(10, 42, 146, 17);
		panel_1.add(label_7);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtPrimerNom = new JTextField();
		txtPrimerNom.setBounds(217, 37, 197, 28);
		panel_1.add(txtPrimerNom);
		txtPrimerNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrimerNom.setColumns(10);
		
		JLabel label = new JLabel("SEGUNDO NOMBRE");
		label.setBounds(456, 40, 146, 17);
		panel_1.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtSegunNom = new JTextField();
		txtSegunNom.setBounds(629, 35, 197, 28);
		panel_1.add(txtSegunNom);
		txtSegunNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSegunNom.setColumns(10);
		
		JLabel label_1 = new JLabel("PRIMER APELLIDO");
		label_1.setBounds(838, 42, 146, 17);
		panel_1.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtPrimerApe = new JTextField();
		txtPrimerApe.setBounds(1002, 37, 197, 28);
		panel_1.add(txtPrimerApe);
		txtPrimerApe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrimerApe.setColumns(10);
		
		txtSegundoApe = new JTextField();
		txtSegundoApe.setBounds(217, 68, 197, 28);
		panel_1.add(txtSegundoApe);
		txtSegundoApe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSegundoApe.setColumns(10);
		
		JLabel label_2 = new JLabel("SEGUNDO APELLIDO");
		label_2.setBounds(10, 73, 146, 17);
		panel_1.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("FECHA DE NACIMIENTO");
		label_3.setBounds(456, 73, 160, 17);
		panel_1.add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("ESTADO CIVIL");
		label_4.setBounds(10, 109, 146, 17);
		panel_1.add(label_4);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		final JComboBox comboEstadoCivil = new JComboBox();
		comboEstadoCivil.setBounds(217, 102, 197, 30);
		panel_1.add(comboEstadoCivil);
		
		JLabel label_5 = new JLabel("OCUPACION");
		label_5.setBounds(456, 109, 146, 17);
		panel_1.add(label_5);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtOcupacion = new JTextField();
		txtOcupacion.setBounds(629, 102, 197, 28);
		panel_1.add(txtOcupacion);
		txtOcupacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOcupacion.setColumns(10);
		
		JLabel lblCelular = new JLabel("CELULAR");
		lblCelular.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCelular.setBounds(838, 76, 146, 17);
		panel_1.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtCelular.setColumns(10);
		txtCelular.setBounds(1002, 71, 197, 28);
		panel_1.add(txtCelular);

		final JComboBox comboSexo = new JComboBox();
		comboSexo.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONE UNA OPCION", "FEMENINO", "MASCULINO"}));
		comboSexo.setBounds(1002, 102, 197, 30);
		panel_1.add(comboSexo);
		
		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblSexo.setBounds(838, 109, 146, 17);
		panel_1.add(lblSexo);
		
		
		InterfazGrafica.CambiarEstadoElem(panel_1,false);
		
		
		final JDateChooser dateChFechaNac = new JDateChooser();
		dateChFechaNac.setDateFormatString("yyyy/MM/dd");
		dateChFechaNac.setBounds(629, 68, 197, 28);
		dateChFechaNac.setEnabled(false);
		panel_1.add(dateChFechaNac);
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "DATOS DEL LUMISIAL", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_2.setBounds(35, 281, 1232, 216);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLumisial = new JLabel("PAIS");
		lblLumisial.setBounds(451, 73, 57, 17);
		panel_2.add(lblLumisial);
		lblLumisial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		final JComboBox comboLumisial = new JComboBox();
		comboLumisial.setBounds(620, 150, 197, 30);
		panel_2.add(comboLumisial);

		
		final JComboBox comboDiocesis = new JComboBox();
		comboDiocesis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				DiocesisModel objDiocesisModel = (DiocesisModel)comboDiocesis.getSelectedItem();
				
				if(objDiocesisModel != null){
					
					int diocesisCod = objDiocesisModel.getDiocesisCod();
					
					DefaultComboBoxModel comboLumisialModel = new DefaultComboBoxModel(objIntegrantesController.loadDataLumisialCombo(diocesisCod));
					comboLumisial.setModel(comboLumisialModel);	
					
				}
				
			}
		});
		comboDiocesis.setBounds(620, 108, 197, 30);
		panel_2.add(comboDiocesis);
		
		final JComboBox comboPais = new JComboBox();
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
		comboPais.setBounds(620, 66, 197, 30);
		panel_2.add(comboPais);
		
		final JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "PERTENECE A:", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_3.setBounds(12, 29, 421, 146);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		final JCheckBox chckbxJuntaSacer = new JCheckBox("JUNTA SACERDOTAL");
		chckbxJuntaSacer.setBackground(Color.LIGHT_GRAY);
		chckbxJuntaSacer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxJuntaSacer.setBounds(6, 31, 164, 25);
		panel_3.add(chckbxJuntaSacer);
		
		final JCheckBox chckbxCatequista = new JCheckBox("CATEQUISTA");
		chckbxCatequista.setBackground(Color.LIGHT_GRAY);
		chckbxCatequista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCatequista.setBounds(203, 31, 113, 25);
		panel_3.add(chckbxCatequista);
		
		final JCheckBox chckbxJuntaAdmin = new JCheckBox("JUNTA ADMINISTRATIVA");
		chckbxJuntaAdmin.setBackground(Color.LIGHT_GRAY);
		chckbxJuntaAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxJuntaAdmin.setBounds(4, 86, 185, 25);
		panel_3.add(chckbxJuntaAdmin);
		
		final JCheckBox chckbxJuntaDam = new JCheckBox("JUNTA DE DE DAMAS");
		chckbxJuntaDam.setBackground(Color.LIGHT_GRAY);
		chckbxJuntaDam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxJuntaDam.setBounds(6, 58, 168, 25);
		panel_3.add(chckbxJuntaDam);
		
		final JCheckBox chckbxCatorceno = new JCheckBox("CATORCENO");
		chckbxCatorceno.setBackground(Color.LIGHT_GRAY);
		chckbxCatorceno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCatorceno.setBounds(203, 87, 114, 25);
		panel_3.add(chckbxCatorceno);
		
		final JCheckBox chckbxJuntaAdministrativaDepartamental = new JCheckBox("JUNTA ADMINISTRATIVA DEPARTAMENTAL");
		chckbxJuntaAdministrativaDepartamental.setBackground(Color.LIGHT_GRAY);
		chckbxJuntaAdministrativaDepartamental.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxJuntaAdministrativaDepartamental.setBounds(6, 114, 311, 25);
		panel_3.add(chckbxJuntaAdministrativaDepartamental);
		
		final JCheckBox chckbxCoro = new JCheckBox("CORO");
		chckbxCoro.setBounds(203, 60, 106, 24);
		panel_3.add(chckbxCoro);
		chckbxCoro.setBackground(Color.LIGHT_GRAY);
		chckbxCoro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblObservaciones = new JLabel("OBSERVACIONES");
		lblObservaciones.setBounds(831, 37, 130, 17);
		panel_2.add(lblObservaciones);
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNumeroDeCarnet = new JLabel("NUMERO DE CARNET");
		lblNumeroDeCarnet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDeCarnet.setBounds(451, 37, 147, 17);
		panel_2.add(lblNumeroDeCarnet);
		
		txtNumCarnet = new JTextField();
		txtNumCarnet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumCarnet.setColumns(10);
		txtNumCarnet.setBounds(620, 32, 197, 28);
		panel_2.add(txtNumCarnet);
		
		JLabel label_6 = new JLabel("LUMISIAL");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(451, 157, 60, 17);
		panel_2.add(label_6);
		
		JLabel lblDiocesis = new JLabel("DIOCESIS");
		lblDiocesis.setBounds(451, 115, 81, 17);
		panel_2.add(lblDiocesis);
		lblDiocesis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		final JTextArea textAObjservaciones = new JTextArea();
		textAObjservaciones.setBounds(979, 29, 241, 146);
		panel_2.add(textAObjservaciones);
		InterfazGrafica.CambiarEstadoElem(panel_2, false);
		InterfazGrafica.CambiarEstadoElem(panel_3, false);
		
		final JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String getidentidad	= txtIdentidad.getText();
				int identidad		= Integer.parseInt(getidentidad);
				
				String primerNom	= txtPrimerNom.getText();
				String segundoNom	= txtSegunNom.getText();
				String primerApe	= txtPrimerApe.getText();
				String segundoApe	= txtSegundoApe.getText();
				String ocupacion	= txtOcupacion.getText();
				
				String getCelular	= txtCelular.getText();
				
				int celular = 0;
				if(!getCelular.equals("")){
					celular			= Integer.parseInt(getCelular);
				}
				
				String getCarnet	= txtNumCarnet.getText();
				int carnet = 0;
				if(!getCarnet.equals("")){
					carnet			= Integer.parseInt(getCarnet);
					
				}
							
				//String estadoCivil = (String) comboEstadoCivil.getSelectedItem();
				EstadoCivilModel objEstadoCivilModel = (EstadoCivilModel) comboEstadoCivil.getSelectedItem();
				String estadoCivil = objEstadoCivilModel.getEstadoCivilCod();
				
				String observaciones = textAObjservaciones.getText(); 
				String cargos = InterfazGrafica.cargos(panel_3);
				String sexo = objIntegrantesController.sexo(comboSexo); 
				Blob getBlob = null;
				
				int lumisialCod = 0;
				LumisialModel objLumisial= (LumisialModel) comboLumisial.getSelectedItem();
				if(objLumisial != null){
					lumisialCod = objLumisial.getLumisialCode();
				}
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date getfechaNac = dateChFechaNac.getDate();
				String fechaNac = dateFormat.format(getfechaNac);
				
				
				Retorno objRetorno = objIntegrantesController.registrarIntegrante(identidad,carnet, primerNom, segundoNom, primerApe, segundoApe,ocupacion,celular, sexo, estadoCivil, fechaNac, getBlob, cargos, observaciones, lumisialCod);
				
				if(!objRetorno.isError()){
					
					if(objRetorno.isEncoRgis()){
						
						JOptionPane.showMessageDialog(null, "SE HA REGISTRADO EN LA BASE DE DATOS");
						
						InterfazGrafica.setNullElements(panel);
						InterfazGrafica.setNullElements(panel_1);
						InterfazGrafica.setNullElements(panel_2);
						InterfazGrafica.setNullElements(panel_3);
						
						InterfazGrafica.CambiarEstadoElem(panel_1, false);
						InterfazGrafica.CambiarEstadoElem(panel_2, false);
						InterfazGrafica.CambiarEstadoElem(panel_3, false);
						
					}
				}else{
					JOptionPane.showMessageDialog(null, objRetorno.getErrorMsg());
				}
			}
		});
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(454, 509, 137, 34);
		getContentPane().add(btnGuardar);
		
		final JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setEnabled(false);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(650, 509, 137, 34);
		getContentPane().add(btnCancelar);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String getIdentidad = txtIdentidad.getText();
				int identidad = Integer.parseInt(getIdentidad);
				
				int opcionBusqueda = comboOpcionBusqueda.getSelectedIndex();
				if(opcionBusqueda != 0){
					
					Retorno objRetorno = objIntegrantesController.buscarIntegrante(identidad, opcionBusqueda);
					
					if(!objRetorno.isError()){
						
						if(objRetorno.isEncoRgis()){
							
							int pregunta = JOptionPane.showConfirmDialog(null, "LA PERSONA ESTA REGISTRADA , ¿DESEA VER LOS DATOS?");
							
							if(pregunta == 0){
								
								IntegrantesModel objIntegrantesModel= objIntegrantesController.loadDataForm(identidad);
								
								//para mostrar informacion en el formulario
								if(objIntegrantesModel != null){
									
									txtPrimerNom.setText(objIntegrantesModel.getNombre1());
									txtSegunNom.setText(objIntegrantesModel.getNombre2());
									txtPrimerApe.setText(objIntegrantesModel.getApellido1());
									txtSegundoApe.setText(objIntegrantesModel.getApellido2());
									txtCelular.setText(Integer.toString(objIntegrantesModel.getCelular()));
									txtNumCarnet.setText(Integer.toString(objIntegrantesModel.getCarnet()));
									txtOcupacion.setText(objIntegrantesModel.getOcupacion());
									
									//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
									//Date getfechaNac = dateChFechaNac.setDate();
									//String fechaNac = dateFormat.format(getfechaNac);
									
									
									String getGenero = objIntegrantesModel.getGenero();
									
									if(getGenero == "F"){
										comboSexo.setSelectedIndex(1);
										
									}else{
										comboSexo.setSelectedIndex(2);
									}
									
								}
							}
							
						}else{
							
							int pregunta = JOptionPane.showConfirmDialog(null, "LA PERSONA NO ESTA EN LA BASE DE DATOS , ¿DESEA REGISTRARLO?");
							
							if(pregunta == 0){
								
								InterfazGrafica.CambiarEstadoElem(panel_1, true);
								InterfazGrafica.CambiarEstadoElem(panel_2, true);
								InterfazGrafica.CambiarEstadoElem(panel_3, true);
								
								btnGuardar.setEnabled(true);
								btnCancelar.setEnabled(true);
								
								DiocesisController objDiocesisController = new DiocesisController();
								DefaultComboBoxModel comboPaisModel = new DefaultComboBoxModel(objDiocesisController.loadDataCombo());
								comboPais.setModel(comboPaisModel);
								
								DefaultComboBoxModel comboEstadoCivilModel= new DefaultComboBoxModel(objIntegrantesController.loadDataEstadoCivilCombo()) ;
								comboEstadoCivil.setModel(comboEstadoCivilModel);
							}
							
						}
						
					}else{
						JOptionPane.showMessageDialog(null, objRetorno.getErrorMsg());
					}
					
				}
			}
					
								
				
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(906, 28, 137, 34);
		panel.add(btnConsultar);		

	}
}
