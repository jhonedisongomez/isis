package servicios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObtenerFecha {
  public  String obtenerFecha() {

	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   String fecha= dateFormat.format(date);
	   return fecha;
	   
  }
}
