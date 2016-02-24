package servicios;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MetodosTeclado {
	
	
	//PARA ESPACIOS
    public void sinEspacios(JTextField texto){
		 
		texto.addKeyListener(new KeyAdapter() {	 
			public void keyTyped (KeyEvent e){			 
				char caracter= e.getKeyChar();
				if(Character.isWhitespace(caracter)){					 
					JOptionPane.showMessageDialog(null, "NO SE PERMITEN ESPACIOS EN BLANCO");
					e.consume();
				}
			}
		});
	}
    
    

	//PARA NUMEROS
    public void sinNumeros(JTextField texto){
			 
		texto.addKeyListener(new KeyAdapter() {				 
			public void keyTyped (KeyEvent e){					 
				char caracter= e.getKeyChar();
				if(Character.isDigit(caracter)){
				    JOptionPane.showMessageDialog(null, "NO SE PERMITEN NUMEROS");
					e.consume();
				} 
			}
		});
	}
		
    
	//PARA LETRAS
    public void sinLetras(JTextField texto){
			 
    	texto.addKeyListener(new KeyAdapter() {				 
    		public void keyTyped (KeyEvent e){			 
				char caracter= e.getKeyChar();
				if(Character.isLetter(caracter)){
					JOptionPane.showMessageDialog(null, "NO SE PERMITEN LETRAS");
					e.consume();
				}
			}
    	});
	}//fin del metodo sletras
		
    
    
	//PARA CARACTERES 
    public void sinCaracteres(JTextField texto){
			 
		texto.addKeyListener(new KeyAdapter() {			 
			public void keyTyped (KeyEvent e){			 
				char caracter= e.getKeyChar();
				if(caracter >=33 && caracter<=47){
					JOptionPane.showMessageDialog(null, "NO SE PERMITEN CARACTERES");
				    e.consume();
				}
			}
		});
	}//fin del metodo scaracteres

    
    
    
}// fin de la clase Metodos
