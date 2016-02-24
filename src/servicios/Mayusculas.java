package servicios;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


class Mayusculas extends PlainDocument {
	 
	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	      super.insertString(offset, str.toUpperCase(), attr);
	    //textField.setDocument(new JTextFieldToUpperCase());
	    }
	  }
