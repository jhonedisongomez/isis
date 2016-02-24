package diocesis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JOptionPane;

import pais.PaisModel;
import servicios.ConexionDataBase;
import servicios.ObtenerFecha;

public class DiocesisController {
	
	
	ConexionDataBase objConexionDataBase = new ConexionDataBase();
	ObtenerFecha objObtenerFecha = new ObtenerFecha();
	String fecha = objObtenerFecha.obtenerFecha();
	
	String nombreUsuario = "jhon";
	

	public DiocesisModel loadDataForm (int diocesisCod){
		
		DiocesisModel objDiocesisModel = null;
		
		try {
			
			String querySQL = "select * from diosesis where active = true and diosesisCod = " + diocesisCod;
			ResultSet response= objConexionDataBase.executeQuery(querySQL);
		
			while(response.next()){
				
				int diocCod			= response.getInt("diosesisCod");
				String diocesisNom	= response.getString("diosesisNom"); 
				int fk_paisCod		= response.getInt("fk_paisCod");
				
				objDiocesisModel = new DiocesisModel(diocCod, diocesisNom, fk_paisCod);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return objDiocesisModel;
		
		
		
	}
	
	public Vector<PaisModel> loadDataCombo(){
		
		Vector<PaisModel> paises = new Vector<PaisModel>();
		try {
			
			PaisModel objPaisModel = null;
			String querySQL = "select * from pais where active = true order by paisNom";
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
			
			while(response.next()){
				
				objPaisModel = new PaisModel();
				objPaisModel.setPaisNom(response.getString("paisNom"));
				objPaisModel.setPaisCod(response.getInt("paisCod"));
				paises.add(objPaisModel);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String respuesta = "error al cargar la base de datos";
			
		}
		
		return paises;
		
	}
	
	
	public boolean buscarDiocesis(int diocesisCod) {
		
		boolean find = false;
		
		try {
			
			String querySQL = "select * from diosesis where active = true and diosesisCod = " + diocesisCod;
			ResultSet response = objConexionDataBase.executeQuery(querySQL);
		
			
			response.last();
			int rowsCounter =response.getRow();
			
			if(rowsCounter >0){
				find = true;
			}
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "error");
		}
		
		return find;
		
	}
	
	public boolean guardarDiocesis(int diocesisCod, String diocesisNom, int pais){
		
		boolean registro = false;
		
		try{
			
			UUID diocesisUUID = UUID.randomUUID();
			
			String querySQL = "INSERT INTO diosesis (diosesisUUID,diosesisCod,diosesisNom,active,createBy,CreateDT,UpdateBy,UpdateDT,fk_PaisCod) values ('"
					+ diocesisUUID + "','" + diocesisCod + "','" + diocesisNom + "',true,'" + nombreUsuario +"','" + fecha + "','"
					+ nombreUsuario +"','" + fecha + "',"+ pais + ")"; 
			
			objConexionDataBase.executeUpdateQuery(querySQL);
			registro = true;
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR LA DIOCESIS");
			registro = false;
			
		}
		
		return registro;
	}
}
