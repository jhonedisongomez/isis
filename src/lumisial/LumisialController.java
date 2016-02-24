package lumisial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JOptionPane;

import ciudad.CiudadModel;
import diocesis.DiocesisModel;
import servicios.ConexionDataBase;
import servicios.ObtenerFecha;

public class LumisialController {
	
	ConexionDataBase objConexionDataBase = new ConexionDataBase();
	ObtenerFecha objObtenerFecha = new ObtenerFecha();
	String fecha = objObtenerFecha.obtenerFecha();
	
	String nombreUsuario = "jhon";
	
	
public LumisialModel loadDataForm (int lumisialCod){
		
		LumisialModel objLumisialModel = null;
		
		try {
			
			String querySQL = "select * from lumisial where active = true and lumisialCod = " + lumisialCod;
			ResultSet response= objConexionDataBase.executeQuery(querySQL);
		
			while(response.next()){
				
				int lumCod			= response.getInt("lumisialCod");
				String lumisialNom	= response.getString("lumisialNom"); 
				int lumisialTel		= response.getInt("lumisialTel");
				String lumisialDir	= response.getString("lumisialDir");
				int fk_ciudadCod	= response.getInt("fk_ciudadCod");
				
				objLumisialModel = new LumisialModel(lumCod, lumisialNom, lumisialDir, lumisialTel,fk_ciudadCod);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return objLumisialModel;
		
		
		
	}
	
	
	
	public Vector<DiocesisModel> loadDataDiocesisCombo(int paisCod){
		
		Vector<DiocesisModel> diocesis = new Vector<DiocesisModel>();
		try {
			
			DiocesisModel objDiocesisModel = null;
			String querySQL = "select * from diosesis where active = true and fk_paisCod = "+ paisCod + " order by diosesisNom";
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
			
			while(response.next()){
				
				objDiocesisModel = new DiocesisModel();
				objDiocesisModel.setDiocesisNom(response.getString("diosesisNom"));
				objDiocesisModel.setDiocesisCod(response.getInt("diosesisCod"));
				diocesis.add(objDiocesisModel);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String respuesta = "error al cargar la base de datos";
			
		}
		
		return diocesis;
		
	}
	
public Vector<CiudadModel> loadDataCiudadCombo(int diocesisCod){
		
		Vector<CiudadModel> ciudades = new Vector<CiudadModel>();
		try {
			
			CiudadModel objCiudadModel = null;
			String querySQL = "select * from ciudad where active = true and fk_diocesisCod = " +diocesisCod +" order by ciudadNom";
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
			
			while(response.next()){
				
				objCiudadModel = new CiudadModel();
				objCiudadModel.setCiudadNom(response.getString("ciudadNom"));
				objCiudadModel.setCiudadCod(response.getInt("ciudadCod"));
				ciudades.add(objCiudadModel);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String respuesta = "error al cargar la base de datos";
			
		}
		
		return ciudades;
		
	}	
	
	public boolean consultarLumisial(int lumisialCod){
		
		boolean find = false;
		
		try{
			
			String querySQL = "select * from lumisial where active = true and lumisialCod =" + lumisialCod;
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
			
			response.last();
			int rowsCounter =response.getRow();
			
			if(rowsCounter >0){
				find = true;
				
			}
			
			
		}catch(Exception e ){
			
			JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR EL LUMISIAL EN LA BASE DE DATOS");
			
		}
		
		
		return find;
		
	}
	
	public boolean registrarLumisial(int lumisialCod, String lumisialNom, int lumisialTel, String lumisialDir,int ciudadCod){
		
		boolean registro = false;
		try{
		
			UUID lumisialUUID = UUID.randomUUID();
			
			String querySQL = "INSERT INTO lumisial (lumisialUUID,lumisialCod,lumisialNom,lumisialDir,lumisialTel,active,createBy,CreateDT,UpdateBy,UpdateDT,fk_ciudadCod) values ('"
					+ lumisialUUID + "','" + lumisialCod + "','" + lumisialNom + "','"+ lumisialDir + "'," + lumisialTel + ",true,'" + nombreUsuario +"','" + fecha + "','"
					+ nombreUsuario +"','" + fecha + "',"+ ciudadCod + ")"; 
			
			objConexionDataBase.executeUpdateQuery(querySQL);
			registro = true;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "ERROR EN EL REGISTRO");
			
		}
		
		return registro;
		
	}

}
