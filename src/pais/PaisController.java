package pais;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import servicios.ConexionDataBase;
import servicios.ObtenerFecha;
import servicios.Retorno;

public class PaisController {
	
	String nombreUsuario = "jhon";
	ConexionDataBase objConexionDataBase = new ConexionDataBase();

	ObtenerFecha objObtenerFecha = new ObtenerFecha();
	String fecha = objObtenerFecha.obtenerFecha();
	
	
	public String loadDataForm(int paisCod){
		
		String paisNom = "";
		
		try {
			
			String querySQL = "select paisNom from pais where active = true and paisCod = " + paisCod;
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
			
			while(response.next()){
				paisNom = response.getString("paisNom");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return paisNom;
		
	}
	
	public boolean buscarPais(int paisCod){
		boolean find = false;
		try {
			
			
			
			String querySQL = "select * from pais where paisCod = " + paisCod + " and active = true";
			ResultSet response =  objConexionDataBase.executeQuery(querySQL);
			
			response.last();
			int rowsCounter =response.getRow();
			
			if(rowsCounter >0){
				find = true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		return find;
		
		
	}
	

	
	public boolean registrarPais(int paisCod, String paisNom){
		
		boolean registro = true;
		
		try{
			
			UUID paisUUID = UUID.randomUUID();
			
			
			String querySQL = "INSERT INTO Pais (paisUUID,paisCod,paisNom,active,createBy,CreateDT,UpdateBy,UpdateDT) values ('"
					+ paisUUID + "','" + paisCod + "','" + paisNom + "',true,'" + nombreUsuario +"','" + fecha + "','"
					+ nombreUsuario +"','" + fecha + "')"; 
			
			objConexionDataBase.executeUpdateQuery(querySQL);
			
			
		}catch(Exception e ){
			
			e.printStackTrace();
			registro = false;
			
		}
		
		return registro;
		
	}
	
	public void actualizarPais(int paisCod, String paisNom){
		
		try{
			
			String querySQL = "select * from pais where paisCod = " + paisCod + " and active = true";
			ResultSet response =  objConexionDataBase.executeQuery(querySQL);
			int rowsCounter =response.getRow();
			
			if(rowsCounter >0){
				
				while(response.next()){
					
					String paisUUID = response.getString("paisUUID");
					String oldRecord = "update pais set active = false where paisUUID ='" + paisUUID + "'";
					objConexionDataBase.executeUpdateQuery(oldRecord);
					
					String newRecord = "INSERT INTO Pais (paisUUID,paisCod,paisNom,active,createBy,CreateDT,UpdateBy,UpdateDT) values ('"
							+ paisUUID + "','" + paisCod + "','" + paisNom + "',true,'" + nombreUsuario +"','" + fecha + "','"
							+ nombreUsuario +"','" + fecha + "')"; 
					
					objConexionDataBase.executeUpdateQuery(newRecord);
					
					
					
					
				}
			
			}
			
		}catch(Exception e ){
			
			e.printStackTrace();
			
		}
		
		
	}
	

}
