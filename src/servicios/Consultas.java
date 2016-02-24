package servicios;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.Query;

public class Consultas {
	
	static ConexionDataBase objConexionDataBase = new ConexionDataBase();
	
	public static Retorno listar(String query){
		
		Retorno objRetorno = null;
		ResultSet response = null;
		boolean error = false;
		String errorMsg = "";
		try{
			
			//String querySQL = "select  paisNom,paisCod from pais where active = true order by paisNom";
			response = objConexionDataBase.executeQuery(query);
			
			
		}catch(Exception e){
			
			error = true;
			errorMsg = "ERROR AL LISTAR LOS PAISES";
			
		}
		
		objRetorno = new Retorno(error, errorMsg, response);
		return objRetorno;
		
	}
	
	public static String lumisialNom(String lumisialCod){
		
		String lumisialNom ="";
		try {
			
			String querySQL = "select lumisialNom from lumisial where active = true and lumisialCod = " + lumisialCod;
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
			
		
			while(response.next()){
				
				lumisialNom = response.getString("lumisialNom");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lumisialNom;
	}
	
public static String EstadiCivilDesc(String estadoCivilCod){
		
		String estadoCivilDesc ="";
		try {
			
			String querySQL = "select estadoCivilDesc from estadoCivil where active = true and estadoCivilCod = '" + estadoCivilCod + "'";
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
			
		
			while(response.next()){
				
				estadoCivilDesc = response.getString("estadoCivilDesc");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estadoCivilDesc;
	}

}
