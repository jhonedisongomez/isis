package integrantes;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JComboBox;

import estadoCivil.EstadoCivilModel;
import lumisial.LumisialModel;
import servicios.ConexionDataBase;
import servicios.ObtenerFecha;
import servicios.Retorno;

public class IntegrantesController {
	
	ConexionDataBase objConexionDataBase = new ConexionDataBase();
	ObtenerFecha objObtenerFecha = new ObtenerFecha();
	String fecha = objObtenerFecha.obtenerFecha();
	
	String nombreUsuario = "jhon";
	
	
	/*
	 * opcionBusqueda tiene las siguientes opciones
	 * 
	 * 1. cedula
	 * 2. carnet
	 * 
	 * */
	public Retorno buscarIntegrante(int identidad,int opcionBusqueda){
		
		boolean find = false;
		boolean error = false;
		String errorMsg = "";
		
		String opcion = "";
		
		try{
			
			if(opcionBusqueda == 1){
				
				opcion = "identidad";
			}else{
				opcion = "carnet";
			}
			
			
			String querySQL = "select * from asistente where active = true and " + opcion +" = " + identidad;
			System.out.println(querySQL);
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
			response.last();
			int rowsCounter =response.getRow();
			
			if(rowsCounter >0){
				find = true;
				
			}
			
		}catch(Exception e){
			
			//e.printStackTrace();
			errorMsg = "ERROR AL ENCONTRAR LA PERSONA EN ESTE LUMISIAL";
			error = true;
		}
		
		Retorno objRetorno = new Retorno(find, error,errorMsg);
		return objRetorno;
		
	}
	
	public Vector<LumisialModel> loadDataLumisialCombo(int diocesisCod){
		
		Vector<LumisialModel> lumisiales = new Vector<LumisialModel>();
		try {
			
			LumisialModel objLumisialModel = null;
			//String querySQL = "select * from lumisial where active = true and fk_diocesisCod = "+ diocesisCod + " order by lumisialNom";
			String querySQL = "SELECT * FROM diosesis dio INNER JOIN ciudad ciud "
					+ "ON dio.diosesisCod = ciud.fk_diocesisCod INNER JOIN lumisial lumi "
					+ "ON ciud.ciudadCod = lumi.fk_ciudadCod "
					+ "WHERE "
					+ "dio.active = true AND "
					+ "ciud.active = true AND "
					+ "lumi.active = true AND "
					+ "dio.diosesisCod = " + diocesisCod;
			
			System.out.println(querySQL);
			
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
			
			while(response.next()){
				
				objLumisialModel = new LumisialModel();
				objLumisialModel.setLumisialNom(response.getString("lumisialNom"));
				objLumisialModel.setLumisialCode(response.getInt("lumisialCod"));
				lumisiales.add(objLumisialModel);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return lumisiales;
		
	}//loadDataLumisialCombo
	
	
	public Vector<EstadoCivilModel> loadDataEstadoCivilCombo(){
		
		Vector<EstadoCivilModel> estadoCivil = new Vector<EstadoCivilModel>();
		
		try{
			EstadoCivilModel objEstadoCivilModel = null;
			//String querySQL = "select * from lumisial where active = true and fk_diocesisCod = "+ diocesisCod + " order by lumisialNom";
			String querySQL = "select * from estadoCivil where active = true order by estadoCivilDesc";
			
			
			
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
			
			while(response.next()){
				
				objEstadoCivilModel = new EstadoCivilModel();
				objEstadoCivilModel.setEstadoCivilDesc(response.getString("estadoCivilDesc"));
				objEstadoCivilModel.setEstadoCivilCod(response.getString("estadoCivilCod"));
				estadoCivil.add(objEstadoCivilModel);
				
				
			}
			
			
		}catch(Exception e){
			
		}
		
		return estadoCivil;
	}
	
	
	/*
	 * the following data are required in the database:
	 * first name,midlee name, last name, id,sex,estado civil,
	 * birthdate,rols
	 * 
	 * */
	public Retorno registrarIntegrante(int identidad,int carnet,String primerNom,String segundoNom,String primerApe,String segundoApe,String ocupacion,int celular,
										String sexo,String estadoCivil, String fechaNac,Blob getblob,String cargos,String observaciones,int lumisialCod ){
		
		Retorno objRetorno = null;
		boolean registro = false;
		boolean error = false;
		String errorMsg = "";
		Blob blob = null;
		
		try{
			
			UUID integranteUUID = UUID.randomUUID();
			
			if(getblob != null){
				blob = getblob;
				
			}else{
				blob = null;
			}
			
			String querySQL = "INSERT INTO asistente(asistenteUUID, identidad, carnet, primerNom, segundoNom, primerApe, segundoApe,ocupacion,celular,sexo, fechaNac, foto, cargos, observaciones, active, createBy, createDT, updateBy, updateDT, fk_lumisialCod,fk_estadoCivilCod) values ('"
					+ integranteUUID + "'," + identidad + ", "+ carnet +",'" + primerNom + "','"+ segundoNom + "','"
					+ primerApe + "','"+ segundoApe +"','"+ ocupacion + "'," + celular +",'" + sexo +"','" + fechaNac + "','"+ blob + "','" + cargos + "',' " + observaciones + "',true,'"
					+ nombreUsuario +"','" + fecha + "','" + nombreUsuario +"','" + fecha + "',"+ lumisialCod + ",'"+ estadoCivil +"')"; 
			
			objConexionDataBase.executeUpdateQuery(querySQL);
			registro = true;
			
		}catch(Exception e){
			
			error = true;
			errorMsg = "ERROR AL REGISTRAR UN INTEGRANTE EN LA BASE DE DATOS";
			
		}
		
		objRetorno = new Retorno(registro, error, errorMsg);
		return objRetorno;
	}
	
	public String sexo (JComboBox comboSexo){
		
		String sexo = "";
		
		if(comboSexo.getSelectedIndex() == 1){
			
			sexo = "F";
		}else{
			sexo = "M";
			
		}
		return sexo;
	}
	
	public IntegrantesModel loadDataForm(int identidad){
		
		IntegrantesModel objIntegrantesModel = null;
		
		try {
			
			String querySQL = "select * from asistente where active = true and identidad = " + identidad; 
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
		
		
			while(response.next()){
				
				String nombre1 = response.getString("primerNom");
				String nombre2 = response.getString("segundoNom");
				String apellido1 = response.getString("primerApe");
				String apellido2 = response.getString("segundoApe");
				String fechaNac = response.getString("fechaNac");
				String ocupacion = response.getString("ocupacion");
				
				String getcargos = response.getString("cargos");
				String[] cargos = getcargos.split(",");
				
				String genero = response.getString("sexo");
				
				int carnet = response.getInt("carnet");				
				int celular = response.getInt("celular");
				
				int fk_LumisialCod = response.getInt("fk_lumisialCod");
				String fk_estadoCivilCod = response.getString("fk_estadoCivilCod");
				
				objIntegrantesModel = new IntegrantesModel(identidad, carnet, celular,fk_LumisialCod, nombre1, nombre2, apellido1, apellido2, fechaNac, fk_estadoCivilCod,ocupacion,genero, cargos);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objIntegrantesModel;
	}
	

}
