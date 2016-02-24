package servicios;

import java.sql.ResultSet;

public class Retorno {
	
	boolean encoRgis, error;
	String errorMsg;
	ResultSet response;
	
	public Retorno(boolean encoRgis, boolean error, String errorMsg){
		
		this.encoRgis = encoRgis;
		this.error = error;
		this.errorMsg = errorMsg;
		
		
	}
	
	public Retorno (boolean error,String errorMsg, ResultSet response){
		
		this.error = error;
		this.errorMsg = errorMsg;
		this.response = response;
	}


	public boolean isEncoRgis() {
		return encoRgis;
	}


	public void setEncoRgis(boolean encoRgis) {
		this.encoRgis = encoRgis;
	}


	public boolean isError() {
		return error;
	}


	public void setError(boolean error) {
		this.error = error;
	}


	public String getErrorMsg() {
		return errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public ResultSet getResponse() {
		return response;
	}

	public void setResponse(ResultSet response) {
		this.response = response;
	}
	
	
	
	

}
