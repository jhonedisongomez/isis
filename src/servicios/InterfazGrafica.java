package servicios;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class InterfazGrafica {
	
    public static void CambiarEstadoElem(JPanel panel, boolean habilitado){

        Component[] elementos = panel.getComponents();

        for(int index = 0; index < elementos.length;index++){


            if(elementos[index] instanceof JTextField){

                JTextField getCampo = (JTextField) elementos[index];
                getCampo.setEditable(habilitado);

            }else if(elementos[index] instanceof JComboBox){

                JComboBox getCampo = (JComboBox) elementos[index];
                getCampo.setEnabled(habilitado);

            }else if(elementos[index] instanceof JCheckBox){

                JCheckBox getCampo = (JCheckBox) elementos[index];
                getCampo.setEnabled(habilitado);

            }else if(elementos[index] instanceof JTextArea){

                JTextArea getCampo = (JTextArea) elementos[index];
                getCampo.setEditable(habilitado);

            }else if(elementos[index] instanceof JDateChooser){

                JDateChooser getCampo = (JDateChooser) elementos[index];
                getCampo.setEnabled(habilitado);

            }else if(elementos[index] instanceof JButton)
            {
                JButton button = (JButton) elementos[index];
                button.setEnabled(habilitado);
            }
        }//close for	
    }//close function

	
	public static void setNullElements(JPanel panel){
		
		Component[] elementos = panel.getComponents();
		
		for(int index = 0; index < elementos.length;index++){
			
			
			if(elementos[index] instanceof JTextField){
				
				JTextField getCampo = (JTextField) elementos[index];
				getCampo.setText("");
				
			}else if(elementos[index] instanceof JCheckBox){
				
				JCheckBox getCampo = (JCheckBox) elementos[index];
				getCampo.setSelected(false);
				
			}else if(elementos[index] instanceof JTextArea){
				
				JTextArea getCampo = (JTextArea) elementos[index];
				getCampo.setText("");
				
			}else if(elementos[index] instanceof JDateChooser){
				
				JDateChooser getCampo = (JDateChooser) elementos[index];
				getCampo.setDate(null);
				
			}
		}//close for	
	}//close function	
	
	public static String cargos(JPanel panel){
		
		String cargos = "";
		
		Component [] checkBox = panel.getComponents();
		for(int index = 0; index < checkBox.length; index++){
			
			if(checkBox[index] instanceof JCheckBox){
				
                            JCheckBox cargo = (JCheckBox) checkBox[index];
                            if(cargo.isSelected()){
                                    if(cargos.equals("")){
                                            cargos = cargo.getText();
                                    }else{
                                            cargos = cargos + "," + cargo.getText();
                                    }
                            }
				
			}
		}
		return cargos;
		
	}
	
}
