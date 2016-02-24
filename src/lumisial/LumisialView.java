package lumisial;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ciudad.CiudadController;
import ciudad.CiudadModel;
import diocesis.DiocesisController;
import diocesis.DiocesisModel;
import pais.PaisModel;

public class LumisialView extends JInternalFrame {
	private JTextField txtlumisialTel;
	private JTextField txtLumisialNom;
	private JTextField txtLumisialDir;
	private JTextField txtLumisialCod;

	LumisialController objLumisialController = new LumisialController();
	DiocesisController objDiocesisController = new DiocesisController();
	private boolean recargarCombo;
	
	/**
	 * Create the frame.
	 */
	public LumisialView() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setClosable(true);
		setTitle("REGISTRO DE LUMISIAL");
		setBounds(100, 100, 393, 399);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("CODIGO");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(46, 16, 146, 17);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("NOMBRE");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(46, 57, 146, 17);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("DIRECCI\u00D3N");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(46, 98, 146, 17);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("TELEFONO");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(46, 144, 146, 17);
		getContentPane().add(label_3);
		
		txtlumisialTel = new JTextField();
		txtlumisialTel.setEditable(false);
		txtlumisialTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtlumisialTel.setColumns(10);
		txtlumisialTel.setBounds(129, 139, 197, 28);
		getContentPane().add(txtlumisialTel);
		
		txtLumisialNom = new JTextField();
		txtLumisialNom.setEditable(false);
		txtLumisialNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLumisialNom.setColumns(10);
		txtLumisialNom.setBounds(129, 52, 197, 28);
		getContentPane().add(txtLumisialNom);
		
		txtLumisialDir = new JTextField();
		txtLumisialDir.setEditable(false);
		txtLumisialDir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLumisialDir.setColumns(10);
		txtLumisialDir.setBounds(129, 93, 197, 28);
		getContentPane().add(txtLumisialDir);
		
		final JComboBox comboCiudad = new JComboBox();
		comboCiudad.setBounds(129, 251, 199, 28);
		getContentPane().add(comboCiudad);
		recargarCombo = true;
		
		
		final JComboBox comboDiocesis = new JComboBox();
		comboDiocesis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(recargarCombo){
					//JOptionPane.showMessageDialog(null, "se activo el evento");
					DiocesisModel objDiocesisModel = (DiocesisModel) comboDiocesis.getSelectedItem();
					int diocesisCod	= objDiocesisModel.getDiocesisCod();
					
					comboCiudad.setEnabled(true);
					DefaultComboBoxModel comboCiudadModel = new DefaultComboBoxModel(objLumisialController.loadDataCiudadCombo(diocesisCod));
					comboCiudad.setModel(comboCiudadModel);
				}
					
			}
		});
		comboDiocesis.setBounds(129, 211, 199, 28);
		getContentPane().add(comboDiocesis);
		
		
		final JComboBox ComboPais = new JComboBox();
		ComboPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PaisModel objPaisModel = (PaisModel) ComboPais.getSelectedItem();
				int paisCod = objPaisModel.getPaisCod();
				
				comboCiudad.removeAllItems();
				DefaultComboBoxModel comboDiocesisModel = new DefaultComboBoxModel(objLumisialController.loadDataDiocesisCombo(paisCod));
				comboDiocesis.setModel(comboDiocesisModel);
			}
		});
		ComboPais.setBounds(129, 174, 197, 28);
		getContentPane().add(ComboPais);
		
		
		final JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(199, 319, 125, 26);
		getContentPane().add(btnCancelar);
		
		
		final JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String getLumisialCod = txtLumisialCod.getText();
				int lumisialCod = Integer.parseInt(getLumisialCod);
				
				String lumisialNom = txtLumisialNom.getText();
				
				String getLumisialTel = txtlumisialTel.getText();
				int lumisialTel = Integer.parseInt(getLumisialTel);
				
				String lumisialDir = txtLumisialDir.getText();
				
				CiudadModel objCiudadModel = (CiudadModel) comboCiudad.getSelectedItem();
				int ciudadCod = objCiudadModel.getCiudadCod();
				
				boolean registro = objLumisialController.registrarLumisial(lumisialCod, lumisialNom, lumisialTel, lumisialDir, ciudadCod);
				
				if(registro){
					
					JOptionPane.showMessageDialog(null, "SE HA REGISTRADO EL LUMISIAL EN LA BASE DE DATOS");
					
					txtLumisialCod.setText("");
					txtLumisialNom.setText("");
					txtlumisialTel.setText("");
					txtLumisialDir.setText("");
					
					//comboDiocesis.setSelectedItem(null);
					//comboCiudad.setSelectedItem(null);
					
					txtLumisialNom.setEnabled(false);
					txtlumisialTel.setEnabled(false);
					txtLumisialDir.setEnabled(false);
					
					comboCiudad.setEnabled(false);
					comboDiocesis.setEnabled(false);
					
					btnGuardar.setEnabled(false);
					btnCancelar.setEnabled(false);
					
					
				}
						
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(72, 319, 111, 26);
		getContentPane().add(btnGuardar);
		
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String getLumisialCod = txtLumisialCod.getText();
				int lumisialCod = Integer.parseInt(getLumisialCod);
				boolean encontro = objLumisialController.consultarLumisial(lumisialCod);
				
				
				if(encontro){
					
					int pregunta = JOptionPane.showConfirmDialog(null, "DESEA VER LA INFORMACION DEL LUMISIAL");
					if(pregunta == 0){
						//TODO: rellenar los datos con el lumisial
						recargarCombo = false;
						if(txtLumisialNom.isEnabled() && txtLumisialDir.isEnabled() && txtlumisialTel.isEnabled() &&
								comboDiocesis.isEnabled()){
								
								txtLumisialNom.setEditable(false);
								txtLumisialDir.setEditable(false);
								txtlumisialTel.setEditable(false); 
								comboDiocesis.setEditable(false); 
								comboCiudad.setEditable(false);
								
								txtLumisialNom.setText("");
								txtLumisialDir.setText("");
								txtlumisialTel.setText("");
								
								comboCiudad.removeAllItems();
								comboDiocesis.removeAllItems();
								
								
						}
						//comboDiocesis.setSelectedItem(objDiocesisModel);
						LumisialModel objLumisialModel = objLumisialController.loadDataForm(lumisialCod);
						
						txtLumisialNom.setText(objLumisialModel.getLumisialNom());
						
						int getLumisialTel = objLumisialModel.getLumisialTel();
						String lumisialTel = Integer.toString(getLumisialTel);
						txtlumisialTel.setText(lumisialTel);
						txtLumisialDir.setText(objLumisialModel.getLumisialDir());
					
						CiudadController objCiudadController = new CiudadController();
						CiudadModel objCiudadModel = objCiudadController.loadDataForm(objLumisialModel.getFk_ciudadCod());
						comboCiudad.addItem(objCiudadModel);
						
						//carga de datos para el combo de diocesesis
						DiocesisModel objDiocesisModel = objDiocesisController.loadDataForm(objCiudadModel.getFk_diocesisCod());
						comboDiocesis.addItem(objDiocesisModel);
					}
					
					
				}else{
					
					int pregunta = JOptionPane.showConfirmDialog(null, "EL LUMISIAL NO ESTA EN LA BASE DE DATOS ¿DESEA REGISTRAR EL LUMISIAL EN LA BASE DE DATOS?");
					if(pregunta ==0){
						recargarCombo = true;
						
						txtLumisialNom.setText("");
						txtLumisialDir.setText("");
						txtlumisialTel.setText("");
						
						txtLumisialNom.setEditable(true);
						txtLumisialDir.setEditable(true);
						txtlumisialTel.setEditable(true);
						
						DefaultComboBoxModel comboPaisModel = new DefaultComboBoxModel(objDiocesisController.loadDataCombo());
						ComboPais.setModel(comboPaisModel);
						
				/*		PaisModel objPaisModel = (PaisModel) ComboPais.getSelectedItem();
						int paisCod = objPaisModel.getPaisCod();
						DefaultComboBoxModel comboDiocesisModel = new DefaultComboBoxModel(objLumisialController.loadDataDiocesisCombo(paisCod));
						comboDiocesis.setModel(comboDiocesisModel);*/
						
						
						btnGuardar.setEnabled(true);
						btnCancelar.setEnabled(true);
						
						
						
					}//cierre condicion
				}//cierre else
				
				
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(189, 20, 137, 26);
		getContentPane().add(btnConsultar);
		
		txtLumisialCod = new JTextField();
		txtLumisialCod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLumisialCod.setColumns(10);
		txtLumisialCod.setBounds(131, 16, 48, 28);
		getContentPane().add(txtLumisialCod);
		
		
		JLabel lblCiudad = new JLabel("DIOCESIS");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCiudad.setBounds(46, 217, 146, 17);
		getContentPane().add(lblCiudad);
		
		
		JLabel label_4 = new JLabel("CIUDAD");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_4.setBounds(46, 257, 146, 17);
		getContentPane().add(label_4);
		
		JLabel lblPais = new JLabel("PAIS");
		lblPais.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPais.setBounds(46, 180, 146, 17);
		getContentPane().add(lblPais);
		
	}
}
